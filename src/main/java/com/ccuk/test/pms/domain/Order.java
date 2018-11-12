package com.ccuk.test.pms.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Order....
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "ORDER_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private Collection<Item> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Item> getItems() {
        return Collections.unmodifiableCollection(items);
    }

    public void setItems(Collection<Item> items) {
        this.items.addAll(items);
    }
}
