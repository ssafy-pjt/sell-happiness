package com.sfs.sellhappiness.domain.coupon.dao;

import com.sfs.sellhappiness.domain.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}