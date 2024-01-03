package com.sfs.sellhappiness.domain.items.dao;

import com.sfs.sellhappiness.domain.items.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
