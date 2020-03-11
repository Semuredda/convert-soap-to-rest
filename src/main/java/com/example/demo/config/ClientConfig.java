package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.demo.service.Calculator;

@Configuration
public class ClientConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller msh = new Jaxb2Marshaller();
		msh.setContextPaths("com.example.calculator.wsdl");
		return msh;
	}
	
	@Bean
	public Calculator calculator(Jaxb2Marshaller marshaller) {
		Calculator calc = new Calculator();
		
		calc.setDefaultUri("http://www.dneonline.com/calculator.asmx");
		calc.setMarshaller(marshaller);
		
		calc.setUnmarshaller(marshaller);
		
		return calc;
	}
}
