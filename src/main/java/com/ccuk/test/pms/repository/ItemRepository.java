package com.ccuk.test.pms.repository;

import com.ccuk.test.pms.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
