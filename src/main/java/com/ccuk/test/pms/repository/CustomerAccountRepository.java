package com.ccuk.test.pms.repository;

import com.ccuk.test.pms.domain.CustomerAccount;
import org.springframework.data.repository.CrudRepository;

public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Long> {
}
