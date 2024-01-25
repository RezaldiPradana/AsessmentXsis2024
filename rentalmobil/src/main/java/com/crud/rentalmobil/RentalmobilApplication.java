package com.crud.rentalmobil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.crud.rentalmobil.model"})
public class RentalmobilApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalmobilApplication.class, args);
	}

}
