package com.sfs.sellhappiness.domain.coupon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "coupon")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coupon_id")
    private Long couponId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "coupon_detail_id")
    private CouponDetail couponDetailId;

    /* Todo... 회원ID 추가 */
    private LocalDateTime creDate;
    private LocalDateTime expDate;
    private Integer discountRate;
    private Boolean isUse;

}
