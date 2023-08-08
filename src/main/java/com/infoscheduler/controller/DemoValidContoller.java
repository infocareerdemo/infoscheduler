package com.infoscheduler.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infoscheduler.entity.StockCash;
import com.infoscheduler.repository.StockCashRepository;

@RestController
//@Validated
@RequestMapping("/demo2")
public class DemoValidContoller {
	@Autowired
	StockCashRepository stockCashRepository;

	@GetMapping("/id")
	public Optional<StockCash> getById(@Valid @RequestParam("id") int id, @Valid @RequestParam("name") String symbol) {
		Optional<StockCash> optional = stockCashRepository.findById(id);
		return optional;

	}

}
