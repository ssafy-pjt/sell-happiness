package com.sfs.sellhappiness.domain.payment.api;

import com.sfs.sellhappiness.domain.coupon.exception.alreadyUsedCouponException;
import com.sfs.sellhappiness.domain.coupon.exception.expiredCouponException;
import com.sfs.sellhappiness.domain.coupon.exception.notExistCouponException;
import com.sfs.sellhappiness.domain.order.exception.notExistOrderException;
import com.sfs.sellhappiness.domain.payment.application.PaymentService;
import com.sfs.sellhappiness.domain.payment.dto.CancelData;
import com.sfs.sellhappiness.domain.payment.exception.verifyIamportException;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final Environment env;
    private IamportClient iamportClient;
    private final PaymentService paymentService;

    /* Iamport 초기화 */
    @PostConstruct
    public void init() {
        iamportClient = new IamportClient(env.getProperty("iamport.api.key"), env.getProperty("iamport.api.secret"));
    }

    /*
    * 클라이언트의 스크립트를 조작하여 결제금액의 위변조를 서버단에서 검증을 위한 메소드
    * map에는 imp_uid, amount, 주문번호가 키 값으로 넘어옴
    * 추후에 RequestEntity 만들어서 처리할 예정
    * */
    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody Map<String, String> map)
            throws IamportResponseException, IOException, verifyIamportException, notExistOrderException, notExistCouponException, alreadyUsedCouponException, expiredCouponException {
        IamportResponse<Payment> iamportResponse = iamportClient.paymentByImpUid(map.get("imp_uid"));
        int amount = Integer.parseInt(map.get("amount"));
        long orderNo = Long.parseLong(map.get("orderNo"));
        Long couponNo = null;
        if(map.containsKey("couponNo")) {
            couponNo = Long.parseLong(map.get("couponNo"));
        }

        log.info("amout = {}", iamportResponse.getResponse().getAmount());
        log.info("buyerEmail = {}", iamportResponse.getResponse().getBuyerEmail());
        log.info("imp_uid = {}", iamportResponse.getResponse().getImpUid());


        // coupon 사용 여부에 따른 다른 처리
        if(couponNo == null) {
            paymentService.verifyIamportService(iamportResponse, amount, orderNo, Optional.empty());
        } else {
            paymentService.verifyIamportService(iamportResponse, amount, orderNo, Optional.of(couponNo));
        }


        return ResponseEntity.ok()
                .body(iamportResponse);
    }

    /*
    * 결제 취소를 위한 메소드
    * map에는 imp_uid, reason(환불(취소)이유), checksum(환불금액), refund_holder(환불계좌 예금주)가 키 값으로 넘어옴
    * 추후에 RequestEntity 만들어서 처리할 예정
    * */
    @PostMapping("/cancel")
    public ResponseEntity<?> cancel(@RequestBody Map<String, String> map)
            throws IamportResponseException, IOException {
        IamportResponse<Payment> iamportResponse = iamportClient.paymentByImpUid(map.get("imp_uid"));

        /*
        * Todo...결제 카드사에 따라 코드 다르게 하는 방법 고민해야 함
        */
        String code = "11"; // NH농협 코드

        CancelData cancelData = paymentService.makeCancelData(map, iamportResponse, code);
        IamportResponse<Payment> cancel = iamportClient.cancelPaymentByImpUid(cancelData);

        return ResponseEntity.ok()
                .body(cancel);
    }

}
