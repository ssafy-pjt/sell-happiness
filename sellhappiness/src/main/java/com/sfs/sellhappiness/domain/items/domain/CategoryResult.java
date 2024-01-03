package com.sfs.sellhappiness.domain.items.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor

// 엔티티를 DTO로 변환하기 위한 클래스
public class CategoryResult {

    private Long id;
    private String name;
    private Integer depth;
    private List<CategoryResult> child;

    public static CategoryResult of(Category category){
        return new CategoryResult(
                category.getId(),
                category.getName(),
                category.getDepth(),
                category.getChild().stream().map(CategoryResult::of).collect(Collectors.toList())
        );
    }
}
