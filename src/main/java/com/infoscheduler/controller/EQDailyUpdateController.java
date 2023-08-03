package com.infoscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoscheduler.service.StockPriceDailyUpdateService;



@RestController
@RequestMapping("/eq")
public class EQDailyUpdateController {

	@Autowired
	StockPriceDailyUpdateService stockPriceDailyUpdateService;

	@GetMapping("/dailyupdate")
	public ResponseEntity<Object> updateStockSch() {
		System.out.println("<<<--- scheduler started for StockPrice EQ Daily Update --->>>");
		
		String EQseries="EQ";
		String EQtimestamp="01-DEC-2022";
		return new ResponseEntity<Object>(stockPriceDailyUpdateService.stockPriceEQDailyUpdate(EQseries, EQtimestamp), HttpStatus.OK);

	}

}
