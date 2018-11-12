package com.ccuk.test.pms.service;

import com.ccuk.test.pms.domain.CustomerAccount;
import com.ccuk.test.pms.repository.CustomerAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;

    public CustomerAccountService(final CustomerAccountRepository repository) {
        this.customerAccountRepository = repository;
    }

    public Optional<CustomerAccount> getCustomerAccountId(final Long id) {
        return customerAccountRepository.findById(id);
    }
}
