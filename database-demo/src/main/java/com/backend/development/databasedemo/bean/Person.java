package com.backend.development.databasedemo.bean;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import java.util.Date;

@Data
@EntityScan

public class Person {
    private int id;
    private String name;
    private Date birth_date;
    private String location;
}
