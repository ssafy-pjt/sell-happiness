package com.sfs.sellhappiness.payment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sfs.sellhappiness.order.domain.Order;
import com.sfs.sellhappiness.payment.dto.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity(name = "payment")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long paymentId;

    /* Todo... 회원ID 추가 */

    private String method;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order orderId;
    private Integer amount;
    private LocalDateTime date;
    private PaymentStatus paymentStatus;
}
