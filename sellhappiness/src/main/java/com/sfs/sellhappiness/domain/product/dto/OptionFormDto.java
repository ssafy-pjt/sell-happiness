package com.sfs.sellhappiness.domain.product.dto;

import com.sfs.sellhappiness.domain.items.domain.Option;
import lombok.*;

@Data
@NoArgsConstructor
@Getter @Setter
public class OptionFormDto {

    private Long id;
    private String optionName;
    private String optionValue;
    private int optionType;

    @Builder
    public OptionFormDto(String optionName, String optionValue, int optionType ) {
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.optionType = optionType;
    }

//    public Option toEntity(OptionFormDto dto) {
//        Option entity = Option.builder()
//                .option_name(dto.option_name)
//                .option_value(dto.option_value)
//                .option_type(dto.option_type)
//                .build();
//
//        return entity;
//    }
}
