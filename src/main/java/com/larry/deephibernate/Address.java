package com.larry.deephibernate;

import lombok.Value;

import javax.persistence.Embeddable;

@Value
@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
