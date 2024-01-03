package com.sfs.sellhappiness.domain.order.dao;

import com.sfs.sellhappiness.domain.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
