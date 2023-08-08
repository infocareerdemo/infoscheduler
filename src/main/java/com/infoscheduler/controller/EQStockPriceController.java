package com.infoscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infoscheduler.service.EQStockPriceService;



@RestController
@RequestMapping("/eq")
public class EQStockPriceController {

	@Autowired
	EQStockPriceService eqStockPriceService;

	// Previous day price for the stock cash
	@PostMapping("/pdayspupdate")
	public String pDayEQStockPriceupdate(@Validated @RequestParam(defaultValue = "EQ") String EQseries,
			@RequestParam(defaultValue = "07-DEC-2022") String EQtimestamp) {
		
		System.out.println("<<<--- scheduler started for StockPrice EQ Daily Update --->>>");
		
	//	return new ResponseEntity<Object>(stockPriceDailyUpdateService.stockPriceEQDailyUpdate(EQseries, EQtimestamp), HttpStatus.OK);

		return eqStockPriceService.pDayEQStockPriceData(EQseries, EQtimestamp);

	}
	
	// Previous WEEK price for the stock cash
	@PostMapping("/pweekspupdate")
	public String pWeekEQStockPriceupdate(
			@RequestParam(defaultValue = "EQ") String EQseries,
			@RequestParam(defaultValue = "07-DEC-2022") String fromEQtimestamp,
			@RequestParam(defaultValue = "07-DEC-2022") String toEQtimestamp )	{
		
		System.out.println("<<<--- scheduler started for StockPrice EQ Daily Update --->>>");
		
	//	return new ResponseEntity<Object>(stockPriceDailyUpdateService.stockPriceEQDailyUpdate(EQseries, EQtimestamp), HttpStatus.OK);

//		return eqStockPriceService.pdEQUpdate(EQseries, EQtimestamp);
		
		return "waiting for the data...............";


	}
	
	
	
	// Previous MONTH price for the stock cash
	@PostMapping("/pmonthsppdate")
	public String pMonthEQStockPriceupdate(@RequestParam(defaultValue = "EQ") String EQseries,
			@RequestParam(defaultValue = "07-DEC-2022") String fromEQtimestamp,
			@RequestParam(defaultValue = "07-DEC-2022") String toEQtimestamp) {
		
		System.out.println("<<<--- scheduler started for StockPrice EQ Daily Update --->>>");
		
	//	return new ResponseEntity<Object>(stockPriceDailyUpdateService.stockPriceEQDailyUpdate(EQseries, EQtimestamp), HttpStatus.OK);

	//	return eqStockPriceService.pdEQUpdate(EQseries, EQtimestamp);
		
		return "waiting for the data...............";

	}
	
}
