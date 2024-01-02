package com.sfs.sellhappiness.domain.cart.dao;

import com.sfs.sellhappiness.domain.cart.domain.Cart;
import com.sfs.sellhappiness.domain.cart.dto.res.CartItemsResDto;
import com.sfs.sellhappiness.domain.cart.dto.res.CartItemsResInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // TODO: nativeQuery=true
    // TODO: interface

    @Query(value = "select c.cart_item_id, c.product_id, c.quantity, c.product_item_id, c.cart_id, o.option_type, o.option_id, o.option_name, o.option_value " +
            "from cart_item as c " +
            "inner join option as o on c.product_item_id = o.product_item_id and c.cart_id = 6", nativeQuery=true)
    List<CartItemsResInterface> findCartItems();


//    @Query(value = "select *" +
//            "from cart_item as c " +
//            "inner join option as o on c.product_item_id = o.product_item_id and c.cart_id = 6", nativeQuery=true)
//    List<CartItemsResInterface> findCartItems();
}
