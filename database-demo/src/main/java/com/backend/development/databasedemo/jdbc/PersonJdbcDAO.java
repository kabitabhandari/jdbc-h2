package com.backend.development.databasedemo.jdbc;

import com.backend.development.databasedemo.bean.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//this class talks to the database
@Repository

public class PersonJdbcDAO {
    //connect to database
    @Autowired
    JdbcTemplate jdbcTemplate;






    //select * from person
    public List<Person> findAllPersons(){
        List<Person> persons = jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));
        return persons;

    }

    //select a person from his id
    public Person findById( int id){
        Person person = jdbcTemplate.queryForObject("select * from person where id =?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
        return person;

    }

    public List<Person> findByName(String name) {
        List<Person> persons = jdbcTemplate.query("select * from person where name=?",new Object[]{name},
                new BeanPropertyRowMapper<>(Person.class));
        return persons;
    }
}
