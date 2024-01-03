package com.sfs.sellhappiness.domain.items.application;


import com.sfs.sellhappiness.domain.items.dao.CategoryRepository;
import com.sfs.sellhappiness.domain.items.dao.ItemRepository;
import com.sfs.sellhappiness.domain.items.domain.Item;
import com.sfs.sellhappiness.domain.items.dto.ItemFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void registItem(ItemFormDto itemFormDto) {
        Item item = itemFormDto.toEntity(itemFormDto);
        itemRepository.save(item);
    }

//    @Transactional(rollbackFor = Exception.class)
//    public List<CategoryResult> getCategoryList(){
//        List<CategoryResult> results = categoryRepository.findAll().stream().map(CategoryResult::of).collect(Collectors.toList());
//        return results;
//    }



}
