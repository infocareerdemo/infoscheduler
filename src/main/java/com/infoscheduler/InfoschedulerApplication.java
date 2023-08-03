package com.infoscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InfoschedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoschedulerApplication.class, args);
	}

}
