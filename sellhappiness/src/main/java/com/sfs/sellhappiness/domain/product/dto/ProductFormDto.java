package com.sfs.sellhappiness.domain.product.dto;

import com.sfs.sellhappiness.domain.product.domain.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductFormDto {

    private Long Id;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String productName;

//    @NotNull(message = "재고는 필수 입력 값입니다.")
//    private int stockNumber;

    @NotBlank(message = "상세 내용은 필수 입력 값입니다.")
    private String productDetail;

    private String productSellStatus;

    private String imgUrl;

    @Builder
    public ProductFormDto(String productName, String productDetail, String productSellStatus, String imgUrl) {
        this.productName = productName;
        this.productDetail = productDetail;
        this.productSellStatus = productSellStatus;
        this.imgUrl = imgUrl;
    }

//    public Product toEntity(ProductFormDto dto) {
//        Product entity = Product.builder()
//                .productName(dto.productName)
//                .productDetail(dto.productDetail)
//                .productSellStatus(dto.productSellStatus)
//                .imgUrl(dto.imgUrl)
//                .build();
//
//        return entity;
//    }
}
