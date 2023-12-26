package com.sfs.sellhappiness.order.api;

import com.sfs.sellhappiness.domain.coupon.exception.notExistCouponException;
import com.sfs.sellhappiness.order.application.OrderService;
import com.sfs.sellhappiness.payment.IamportConfig;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.NativeQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final IamportConfig iamportKey;
    private IamportClient iamportClient;
    private final OrderService orderService;

    /* Iamport 초기화 */
    @PostConstruct
    public void init() {
        iamportClient = new IamportClient(iamportKey.getKey(), iamportKey.getSecret());
    }

    /*
     * 사용자가 결제를 한 경우 주문정보 생성하여 DB에 저장하는 메소드
     * iamport 결제 진행후 response로 받는 데이터가 map에 저장되어 넘어옴
     */
    @RequestMapping("/create")
    public ResponseEntity<?> createOrder(Map<String, String> map)
            throws IamportResponseException, IOException, notExistCouponException {
        IamportResponse<Payment> iamportResponse = iamportClient.paymentByImpUid(map.get("imp_uid"));

        //쿠폰 사용여부에 따른 다른 처리
        Long couponNo = null;
        if(map.containsKey("coupon_id")) {
            couponNo = Long.parseLong(map.get("coupon_id"));
        }

        long orderId;
        if(couponNo == null) {
            orderId = orderService.makeOrder(iamportResponse, Optional.empty());
        } else {
            orderId = orderService.makeOrder(iamportResponse, Optional.of(couponNo));
        }

        return ResponseEntity.ok().body(orderId);
    }

    /*
     * 주문이 잘못되었을 때 DB에서 주문 정보 삭제하는 메소드
     */
    @RequestMapping("/delete")
    public ResponseEntity<?> deleteOrder(long orderId) {
        orderService.cancleOrder(orderId);

        return ResponseEntity.ok().build();
    }
}
