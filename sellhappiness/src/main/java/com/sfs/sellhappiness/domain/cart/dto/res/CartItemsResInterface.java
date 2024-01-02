package com.sfs.sellhappiness.domain.cart.dto.res;

public interface CartItemsResInterface {
    Long getCart_Item_Id();
    Long getProduct_Id();
    Integer getQuantity();
    Long getProduct_Item_Id();
    Long getCart_Id();
    Integer getOption_Type();
    Long getOption_Id();
    String getOption_Name();
    String getOption_Value();
}
