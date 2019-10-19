package com.larry.deephibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Getter
@Entity
@Inheritance
@Table(name = "ORDER_ITEM")
@DiscriminatorColumn
public abstract class Item extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories =  new ArrayList<>();

}
