package com.sfs.sellhappiness.domain.items.application;


import com.sfs.sellhappiness.domain.items.dao.CategoryRepository;
import com.sfs.sellhappiness.domain.items.dao.ItemRepository;
import com.sfs.sellhappiness.domain.items.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
