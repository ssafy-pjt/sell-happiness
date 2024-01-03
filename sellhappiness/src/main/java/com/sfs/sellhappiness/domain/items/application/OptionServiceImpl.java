package com.sfs.sellhappiness.domain.items.application;

import com.sfs.sellhappiness.domain.items.dao.OptionRepository;
import com.sfs.sellhappiness.domain.items.dto.OptionFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService{

    private OptionRepository optionRepository;

    @Override
    public void registerOption(OptionFormDto optionFormDto) {

    }
}
