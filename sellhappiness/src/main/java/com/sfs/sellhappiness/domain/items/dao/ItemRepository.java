package com.sfs.sellhappiness.domain.items.dao;

import com.sfs.sellhappiness.domain.items.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
