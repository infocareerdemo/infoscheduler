package com.infoscheduler.controller;

import java.sql.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

// @RestController is needed for the scheduler to run
@RestController
public class DemoScheduleController {



	// ss mm dd MM week yyyy
	@Scheduled(cron = "0 0/1 * * * ?")
	public String demoTask() {
		
		System.out.println("\n <<<--- Demo Task started to run  "+new java.util.Date()+"--->>>\t\n");
		
		System.out.println("\n <<<--- Demo Task END  "+new java.util.Date()+"--->>>\t\n");

		return "<<<--- Demo Scheduler --->>>";

	}

}
