package com.larry.deephibernate;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("A")
public class Album extends Item{

    private String artist;
    private String etc;

}
