package com.sfs.sellhappiness.payment.api;

import com.sfs.sellhappiness.payment.IamportConfig;
import com.sfs.sellhappiness.payment.application.PaymentService;
import com.sfs.sellhappiness.payment.dto.CancelData;
import com.sfs.sellhappiness.payment.exception.verifyIamportException;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/payment")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final IamportConfig iamportKey;
    private IamportClient iamportClient;
    private final PaymentService paymentService;

    /* Iamport 초기화 */
    @PostConstruct
    public void init() {
        iamportClient = new IamportClient(iamportKey.getKey(), iamportKey.getSecret());
    }

    /*
    * 클라이언트의 스크립트를 조작하여 결제금액의 위변조를 서버단에서 검증을 위한 메소드
    * map에는 imp_uid, amount, 주문번호가 키 값으로 넘어옴
    * 추후에 RequestEntity 만들어서 처리할 예정
    * */
    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody Map<String, String> map)
            throws IamportResponseException, IOException, verifyIamportException {
        IamportResponse<Payment> iamportResponse = iamportClient.paymentByImpUid(map.get("imp_uid"));
        int amount = Integer.parseInt(map.get("amount"));
        Long orderNo = Long.parseLong(map.get("orderNo"));

        log.info("amout = {}", iamportResponse.getResponse().getAmount());
        log.info("buyerEmail = {}", iamportResponse.getResponse().getBuyerEmail());
        log.info("imp_uid = {}", iamportResponse.getResponse().getImpUid());


        paymentService.verifyIamportService(iamportResponse, amount, orderNo);

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
