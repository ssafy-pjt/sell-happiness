package com.sfs.sellhappiness.domain.order.application;

import com.sfs.sellhappiness.domain.coupon.dao.CouponRepository;
import com.sfs.sellhappiness.domain.coupon.domain.Coupon;
import com.sfs.sellhappiness.domain.coupon.exception.notExistCouponException;
import com.sfs.sellhappiness.domain.order.dao.OrderRepository;
import com.sfs.sellhappiness.domain.order.domain.Order;
import com.sfs.sellhappiness.domain.order.exception.notExistOrderException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CouponRepository couponRepository;


    @Override
    public long makeOrder(IamportResponse<Payment> iamportResponse, Optional<Long> couponNo)
    throws notExistCouponException {

        Coupon coupon = null;
        if(couponNo.isPresent()) {
            Optional<Coupon> couponOptional = couponRepository.findById(couponNo.get());
            if(couponOptional.isEmpty()) {
                throw new notExistCouponException();
            }
            coupon = couponOptional.get();
        }

        Order order = Order.builder()
                .buyerName(iamportResponse.getResponse().getName())
                .buyerName(iamportResponse.getResponse().getBuyerName())
                .buyerAddress(iamportResponse.getResponse().getBuyerAddr())
                .buyerNumber(iamportResponse.getResponse().getBuyerTel())
                .build();

        if(coupon != null) {
            order.setCouponNo(coupon);
        }
        /*
        * Todo... 저장 하고 order에 orderId가 자동으로 생성되는지 확인하고 return
        * */
        orderRepository.save(order);

        return order.getOrderId();
    }


    @Override
    public void cancleOrder(long orderId)
            throws notExistOrderException {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isEmpty()) {
            throw new notExistOrderException();
        }

        orderRepository.delete(order.get());
    }
}
