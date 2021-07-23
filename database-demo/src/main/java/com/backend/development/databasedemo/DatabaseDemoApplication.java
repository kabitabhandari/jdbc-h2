package com.backend.development.databasedemo;

import com.backend.development.databasedemo.bean.Person;
import com.backend.development.databasedemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {

		SpringApplication.run(DatabaseDemoApplication.class, args);

	}

	// code in command line runner is launced up as soon as application context is ready
	@Override
	public void run(String... args) throws Exception {

		logger.info ("Here are the list of all users: {} ",dao.findAllPersons().toString());

		logger.info ("Find User by Id: {} ",dao.findById(10003).toString());

		logger.info ("Find Users by Name: {} ",dao.findByName("Paul").toString());

		logger.info ("Delete users by Id: {} row(s) deleted... successful",dao.deleteById(10003));

		logger.info ("Insert a Person Object {} ",dao.insertPerson(new Person(123, "Joseph", new Date(), "kathmandu")));

		logger.info ("Updating a Person Object {} ",dao.updatePerson(new Person(123, "JosephH", new Date(),"kathmandu")));

		logger.info ("Here are the list of all users: {} ",dao.findAllPersons().toString());
	}
}
