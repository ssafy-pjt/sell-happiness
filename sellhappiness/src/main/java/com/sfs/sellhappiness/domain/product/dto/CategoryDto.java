package com.sfs.sellhappiness.domain.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoryDto {

    private Long id;

    private String name;
    private Long parentId;
    private List<CategoryDto> child;

    public CategoryDto(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

}
