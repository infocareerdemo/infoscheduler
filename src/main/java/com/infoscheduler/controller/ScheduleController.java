package com.infoscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;

import com.infoscheduler.service.StockPriceDailyUpdateService;

public class ScheduleController {

	@Autowired
	StockPriceDailyUpdateService stockPriceDailyUpdateService;

	// ss mm dd MM week yyyy
	@Scheduled(cron = "0 */5 * * * *")
	public ResponseEntity<Object> updateStockSch() {
		System.out.println("<<<--- scheduler started for StockPrice EQ Daily Update --->>>");
		
		String EQseries="EQ";
		String EQtimestamp="2023-07-21";
		return new ResponseEntity<Object>(stockPriceDailyUpdateService.stockPriceEQDailyUpdate(EQseries, EQtimestamp), HttpStatus.OK);

	}

}
