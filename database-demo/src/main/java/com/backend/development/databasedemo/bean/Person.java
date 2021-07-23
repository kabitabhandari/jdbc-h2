package com.backend.development.databasedemo.bean;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import java.util.Calendar;
import java.util.Date;

@Data
@EntityScan

public class Person {
    private int id;
    private String name;
    private Date birth_date;
    private String location;


    public Person(){

    }

    public Person(int id, String name, Date birth_date, String location) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.location = location;
    }

}
