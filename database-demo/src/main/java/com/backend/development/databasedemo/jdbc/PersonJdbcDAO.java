package com.backend.development.databasedemo.jdbc;

import com.backend.development.databasedemo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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

    public int deleteById(int id) {
        int count = jdbcTemplate.update("delete from person where id =?",new Object[]{id});
        return count;
    }

    public int insertPerson(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(), person.getBirth_date());
    }

    public int updatePerson(Person person) {
        return jdbcTemplate.update("update person " + " set name = ?, location = ?, birth_date = ? " + " where id = ?",
                person.getName(), person.getLocation(), (person.getBirth_date()), person.getId());
    }
}
