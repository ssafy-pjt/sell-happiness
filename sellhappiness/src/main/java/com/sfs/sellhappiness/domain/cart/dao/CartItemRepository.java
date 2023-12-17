package com.sfs.sellhappiness.domain.cart.dao;

import com.sfs.sellhappiness.domain.cart.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
