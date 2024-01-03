package com.sfs.sellhappiness.domain.items.dto;

import com.sfs.sellhappiness.domain.items.domain.Option;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@Getter @Setter
public class OptionFormDto {

    private Long id;
    private String option_name;
    private String option_value;
    private int option_type;

    @Builder
    public OptionFormDto(String option_name, String option_value, int option_type ) {
        this.option_name = option_name;
        this.option_value = option_value;
        this.option_type = option_type;
    }

    public Option toEntity(OptionFormDto dto) {
        Option entity = Option.builder()
                .option_name(dto.option_name)
                .option_value(dto.option_value)
                .option_type(dto.option_type)
                .build();

        return entity;
    }
}
