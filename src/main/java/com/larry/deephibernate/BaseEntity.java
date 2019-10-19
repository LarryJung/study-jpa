package com.larry.deephibernate;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

}
