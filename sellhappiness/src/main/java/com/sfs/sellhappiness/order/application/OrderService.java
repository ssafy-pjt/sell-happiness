package com.sfs.sellhappiness.order.application;

import com.sfs.sellhappiness.domain.coupon.exception.notExistCouponException;
import com.sfs.sellhappiness.order.exception.notExistOrderException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import java.util.Optional;

public interface OrderService {
    public long makeOrder(IamportResponse<Payment> iamportResponse, Optional<Long> couponNo) throws notExistCouponException;
    public void cancleOrder(long orderId) throws notExistOrderException;
}
