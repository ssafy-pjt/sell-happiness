package com.sfs.sellhappiness.domain.coupon.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "coupon_datail")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CouponDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coupon_detail_id")
    private Long couponDetailId;
    private String couponName;
    private String couponContent;

}
