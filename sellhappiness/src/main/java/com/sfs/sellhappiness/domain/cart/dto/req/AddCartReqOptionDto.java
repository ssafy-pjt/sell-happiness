package com.sfs.sellhappiness.domain.cart.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.sfs.sellhappiness.domain.cart.dto.req.AddCartReqOptionDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
public class AddCartReqOptionDto {
    private Long productItemId;
    private Integer quantity; // TODO: wrapper 타입인 이유?
}
