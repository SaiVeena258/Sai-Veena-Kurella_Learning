package com.spring_boot.spring_boot_learning_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CofigurationController {
	
	@Autowired
	private CurrencyService currency;
	
	@RequestMapping("/currency-service")
	public CurrencyService print() {
		return currency;
	}
		
}
