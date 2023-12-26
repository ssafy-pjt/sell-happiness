package com.sfs.sellhappiness.payment.dao;

import com.sfs.sellhappiness.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
