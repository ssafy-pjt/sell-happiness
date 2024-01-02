package com.sfs.sellhappiness.domain.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sfs.sellhappiness.domain.coupon.domain.Coupon;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "order_info")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    /* Todo... 회원ID, 상품리스트 추가 */

    @Nullable
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "coupon_id")
    private Coupon couponNo;
    private String buyerName;
    private String buyerEmail;
    private String buyerNumber;

    /* Todo... 상품리스트 추가하면 상품리스트에서 합계 금액 가져와야함 */
    private Integer amount;

    /* Todo... 추후 배송지 정보 Entity 설계 시 배송지 정보ID로 변환 */
    private String buyerAddress;

}
