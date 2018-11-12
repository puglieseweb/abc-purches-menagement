package com.ccuk.test.pms.controller;


import com.ccuk.test.pms.domain.CustomerAccount;
import com.ccuk.test.pms.domain.Order;
import com.ccuk.test.pms.service.CustomerAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/v1/com/abc/accounts")
public class OrderController {

    private final CustomerAccountService customerAccountService;

    public OrderController(CustomerAccountService customerAccountService) {
        this.customerAccountService = customerAccountService;
    }

    @GetMapping("/{accountId}/orders")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Collection<Order> getCustomerOrders(@PathVariable final Long accountId) {
        Optional<CustomerAccount> account = customerAccountService.getCustomerAccountId(accountId);
        return account.get().getOrders();
    }

    @PostMapping("/{accountId}/orders")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createCustomerOrder() {
        //TODO
    }
}
