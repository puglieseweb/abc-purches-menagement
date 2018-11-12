package com.ccuk.test.pms.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * CustomerAccount ... .
 */
@Entity
@Table(name = "CUSTOMER_ACCOUNTS")
public class CustomerAccount {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "ACCOUNT_ID"), inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    private Collection<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Order> getOrders() {
        return Collections.unmodifiableCollection(orders);
    }

    public void setOrders(Collection<Order> orders) {
        this.orders.addAll(orders);
    }
}

