package com.sfs.sellhappiness.order.dao;

import com.sfs.sellhappiness.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
