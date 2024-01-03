package com.sfs.sellhappiness.domain.cart.dto.res;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class CartItemsResClass {
    Long cart_Item_Id;
    Long product_Id;
    Integer quantity;
    Long product_Item_Id;
    Long cart_Id;
    Integer option_Type;
    Long option_Id;
    String option_Name;
    String option_Value;
}
