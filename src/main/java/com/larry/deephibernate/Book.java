package com.larry.deephibernate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("B")
public class Book extends Item {

    private String author;
    private String isbn;
}
