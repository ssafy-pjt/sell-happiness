package com.sfs.sellhappiness.domain.payment.application;

import com.sfs.sellhappiness.domain.coupon.dao.CouponRepository;
import com.sfs.sellhappiness.domain.coupon.domain.Coupon;
import com.sfs.sellhappiness.domain.coupon.exception.alreadyUsedCouponException;
import com.sfs.sellhappiness.domain.coupon.exception.expiredCouponException;
import com.sfs.sellhappiness.domain.coupon.exception.notExistCouponException;
import com.sfs.sellhappiness.domain.order.dao.OrderRepository;
import com.sfs.sellhappiness.domain.order.domain.Order;
import com.sfs.sellhappiness.domain.order.exception.notExistOrderException;
import com.sfs.sellhappiness.domain.payment.dao.PaymentRepository;
import com.sfs.sellhappiness.domain.payment.dto.CancelData;
import com.sfs.sellhappiness.domain.payment.dto.PaymentStatus;
import com.sfs.sellhappiness.domain.payment.exception.refundAmountIsDifferentException;
import com.sfs.sellhappiness.domain.payment.exception.verifyIamportException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final OrderRepository orderRepository;
    private final CouponRepository couponRepository;
    private final PaymentRepository paymentRepository;

    @Transactional
    @Override
    public void verifyIamportService(IamportResponse<Payment> iamportResponse, int amount, long orderNo, Optional<Long> couponNo)
            throws verifyIamportException, notExistOrderException, notExistCouponException, alreadyUsedCouponException, expiredCouponException {

        /* 주문번호(orderNo)로 금액 가져오기. */
        Optional<Order> order = orderRepository.findById(orderNo);
        // 주문번호에 맞는 정보가 DB에 없을 경우 예외 처리
        if(order.isEmpty()) {
            throw new notExistOrderException();
        }
        int orderAmount = order.get().getAmount();
        /* 구매자가 쿠폰을 사용했으면 금액 처리 */
        if(couponNo.isPresent()) {
            Optional<Coupon> coupon = couponRepository.findById(couponNo.get());
            // 쿠폰번호에 맞는 정보가 DB에 없을 경우 예외 처리
            if(coupon.isEmpty()) {
                throw new notExistCouponException();
            }
            // 쿠폰이 이미 사용된 경우
            if(coupon.get().getIsUse()) {
                throw new alreadyUsedCouponException();
            }
            // 쿠폰 만료기간이 지난 경우
            if(LocalDateTime.now().isAfter(coupon.get().getExpDate())) {
                throw new expiredCouponException();
            }

            int discount = (int)(orderAmount * coupon.get().getDiscountRate() * 0.01);
            orderAmount -= discount;
            log.info("할인된 금액 = {}", discount);
        }
        log.info("최종 결제 금액 = {}", orderAmount);

        /*
        * 실제로 결제된 금액(amount)와, iamport결제내역의 금액이 같은지 확인
        * BigDecimal을 int와 비교하기 위해 intValue()사용
        */
        if(iamportResponse.getResponse().getAmount().intValue() != amount) {
            log.error("PaymentServiceImpl.verifyIamportService(): 실제로 결제된 금액과 아임포트 서버쪽 결제내역 금액이 다릅니다.");
            throw new verifyIamportException();
        }

        /*
        * 실제로 결제된 금액(amount)와 DB에 있는 물건 금액(orderAmount)이 같은지 확인
        */
        if(amount != orderAmount) {
            log.error("PaymentServiceImpl.verifyIamportService(): 실제로 결제된 금액과 DB의 물견 금액이 다릅니다.");
            throw new verifyIamportException();
        }

        /*
        * 여기까지 문제없다면 결제정보를 DB에 저장
        * 만약 쿠폰을 사용했다면 쿠폰 사용 처리
        */
        // 결제정보 DB 저장
        com.sfs.sellhappiness.domain.payment.domain.Payment payment = com.sfs.sellhappiness.domain.payment.domain.Payment.builder()
                .orderId(order.get())
                .amount(orderAmount)
                .date(LocalDateTime.now())
                .paymentStatus(PaymentStatus.COMPLETE)
                .method(iamportResponse.getResponse().getPayMethod())
                .build();
        paymentRepository.save(payment);

        // 쿠폰 사용 처리
        if(couponNo.isPresent()) {
            Optional<Coupon> coupon = couponRepository.findById(couponNo.get());
            if(coupon.isEmpty()) {
                throw new notExistCouponException();
            }
            coupon.get().setIsUse(true);
        }
    }

    public CancelData makeCancelData(Map<String, String> map, IamportResponse<Payment> iamportResponse, String code)
        throws refundAmountIsDifferentException {
        if(iamportResponse.getResponse().getAmount().intValue() != Integer.parseInt(map.get("checksum"))) {
            log.error("PaymentServiceImpl.makeCancelData(): 아임포트 서버쪽 조회된 결제 금액과 환불(취소)될 금액이 다릅니다.");
            throw new refundAmountIsDifferentException();
        }

        CancelData data = new CancelData(iamportResponse.getResponse().getImpUid(), true);
        data.setReason(map.get("reason"));
        data.setChecksum(new BigDecimal(map.get("checksum")));
        data.setRefund_holder(map.get("refund_holder"));
        data.setRefund_bank(code);
        return data;
    }
}
