package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ClientConfig;
import com.example.demo.service.Calculator;

@RestController
public class CalculatorController {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClientConfig.class);
	Calculator calc = context.getBean(Calculator.class);
	
	
	
	@GetMapping({"/", "/add"})
	public int add() {
		return calc.add(7, 10);
	}
}
