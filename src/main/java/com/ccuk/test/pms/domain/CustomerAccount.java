package com.ccuk.test.pms.domain;

import javax.persistence.*;
import java.util.List;

/**
 * CustomerAccount ... .
 */
@Entity
public class CustomerAccount {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

