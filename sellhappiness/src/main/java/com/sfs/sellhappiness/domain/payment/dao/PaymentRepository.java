package com.sfs.sellhappiness.domain.payment.dao;

import com.sfs.sellhappiness.domain.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
