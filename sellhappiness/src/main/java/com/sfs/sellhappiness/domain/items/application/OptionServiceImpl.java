package com.sfs.sellhappiness.domain.items.application;

import com.sfs.sellhappiness.domain.items.dao.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService{

    private OptionRepository optionRepository;

    @Override
    public void registerOption(OptionFormDto optionFormDto) {

    }
}
