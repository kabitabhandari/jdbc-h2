package com.backend.development.databasedemo;

import com.backend.development.databasedemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		logger.info ("User by Id: {} ",dao.findById(10003).toString());
		logger.info ("User by Name: {} ",dao.findByName("Paul").toString());



	}
}
