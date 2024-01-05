package com.sfs.sellhappiness.domain.product.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long Id;

    @Column(name = "category_name")
    private String name;

    // 중간 테이블과의 연관관계
    @OneToMany(mappedBy = "category")
    List<CategoryProduct> products = new ArrayList<>();

    // 자신에 대한 일대다 관계
    @ManyToOne(cascade = CascadeType.PERSIST) // 부모를 영속화하면 자식도 영속화시킴
    @JoinColumn(name = "parent_id")
    private Category parentId;

    @Column(name = "\"depth\"")
    private Integer depth;

    @OneToMany(mappedBy = "parentId", cascade = CascadeType.PERSIST)
    private List<Category> child = new ArrayList<>();

    //연관관계 메서드
    public void addChildCategory(Category child){
        child.setParent(this);
        this.child.add(child);
    }

    public void setParent(Category parentId){
        this.parentId = parentId;
    }

}
