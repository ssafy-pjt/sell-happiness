package com.sfs.sellhappiness.payment.application;

import com.sfs.sellhappiness.payment.dto.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import java.util.Map;

public interface PaymentService {

    public void verifyIamportService(IamportResponse<Payment> iamportResponse, int amount, long orderNo);

    CancelData makeCancelData(Map<String, String> map, IamportResponse<Payment> iamportResponse, String code);
}
