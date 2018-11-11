package com.ccuk.test.pms.repository;

import com.ccuk.test.pms.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
