package com.sfs.sellhappiness.domain.items.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
