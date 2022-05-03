package com.example.MySQLProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@SpringBootApplication
@EnableJpaRepositories("com.example.MySQLProject")
public class MySqlProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlProjectApplication.class, args);

	}
	@Bean
	CommandLineRunner commandLineRunner(record_repository repository) { //run code after the application startup, inject some initial data into database table:record to test this application
		return args -> {
			Record Record1 = new Record("Cola", "in_stock", "2022-3-15", "Joseph");
			Record Record2 = new Record("Paper", "in_stock", "2022-3-13", "Joseph");
			Record Record3 = new Record("Fanta", "Unavailable", "2022-4-1", "Gael");
			Record Record4 = new Record("Cola", "in_stock", "2022-4-3", "Arthur");
			Record Record5 = new Record("Sprite", "Unavailable", "2022-4-1", "Gael");
			Record Record6 = new Record("Tools", "in_stock", "2022-2-12", "Joseph");
			Record Record7 = new Record("Pasta", "Unavailable", "2022-1-31", "Gael");
			Record Record8 = new Record("Tylenol", "in_stock", "2022-2-1", "Gael");
			Record Record9 = new Record("Pan", "Unavailable", "2022-3-21", "Avelynn");
			Record Record10 = new Record("Juice", "Unavailable", "2022-3-13", "Avelynn");
			repository.saveAll(List.of(Record1, Record2, Record3,Record4,Record5,Record6,Record7,Record8,Record9,Record10));
		};
	}
}
