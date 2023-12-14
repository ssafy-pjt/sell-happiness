package com.sfs.sellhappiness.payment.application;

import com.sfs.sellhappiness.payment.dto.CancelData;
import com.sfs.sellhappiness.payment.exception.refundAmountIsDifferentException;
import com.sfs.sellhappiness.payment.exception.verifyIamportException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void verifyIamportService(IamportResponse<Payment> iamportResponse, int amount, long orderNo)
            throws verifyIamportException {
        // Todo... DB 추가하면 주문번호(orderNo)로 금액 가져와야 함.
        int orderAmount = 100;

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
        */
        // Todo... 결제 Entity 설계 후 코드 추가
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
