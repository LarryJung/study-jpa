package com.larry.deephibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    // primitive type 이기 때문에 ddl 은 not null 조건이 걸릴듯
    private int orderPrice;
    private int count;
}
