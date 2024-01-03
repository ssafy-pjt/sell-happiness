package com.sfs.sellhappiness.domain.payment.application;

import com.sfs.sellhappiness.domain.payment.dto.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import java.util.Map;
import java.util.Optional;

public interface PaymentService {

    public void verifyIamportService(IamportResponse<Payment> iamportResponse, int amount, long orderNo, Optional<Long> couponNo);

    public CancelData makeCancelData(Map<String, String> map, IamportResponse<Payment> iamportResponse, String code);
}
