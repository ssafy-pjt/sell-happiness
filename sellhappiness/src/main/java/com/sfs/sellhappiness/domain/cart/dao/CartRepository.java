package com.sfs.sellhappiness.domain.cart.dao;

import com.sfs.sellhappiness.domain.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
