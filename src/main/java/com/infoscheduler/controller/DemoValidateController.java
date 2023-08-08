package com.infoscheduler.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo1")
public class DemoValidateController {


	@GetMapping("/id")
	public int getByid(@Valid @RequestParam("id") int id){
		return id;
		
	}
	@GetMapping("/symbol")
	public  String getBySymbol(@Valid @RequestParam("Symbol") String symbol){
		return symbol;
}}
