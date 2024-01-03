package com.sfs.sellhappiness.domain.items.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

@Entity
@Setter
@Table(name = "Options")
public class Option {


    @Id @GeneratedValue
    @Column(name = "option_id")
    private Long Id;

    // 옵션 이름
    private String option_name;

    // 옵션 값
    private String option_value;

    // 옵션 타입
    private int option_type;

    @Builder
    public Option(String option_name, String option_value, int option_type ) {
        this.option_name = option_name;
        this.option_value = option_value;
        this.option_type = option_type;
    }

}
