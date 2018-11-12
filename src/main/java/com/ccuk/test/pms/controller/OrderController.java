package com.ccuk.test.pms.controller;

//import com.ccuk.test.pms.domain.CustomerAccount;
//import com.ccuk.test.pms.domain.Item;
//import com.ccuk.test.pms.domain.RestUriType;
//import com.ccuk.test.pms.service.CustomerAccountService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/com/abc/accounts")
public class OrderController {

//    private final CustomerAccountService customerAccountService;
//
//    public OrderController(CustomerAccountService customerAccountService) {
//        this.customerAccountService = customerAccountService;
//    }

    @GetMapping("/")
    public String getItemId(@PathVariable final Long id) {
//        return customerAccountService.getCustomerAccountId(id);
        return "test";
    }
}
