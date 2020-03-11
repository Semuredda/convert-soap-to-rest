package com.example.demo.service;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import com.example.calculator.wsdl.Add;
import com.example.calculator.wsdl.AddResponse;
import com.example.calculator.wsdl.ObjectFactory;


public class Calculator extends WebServiceGatewaySupport {
	
	private static final String soapActionURL = "http://tempuri.org/";
	private static final Logger log = LoggerFactory.getLogger(Calculator.class);
	
	public int add(int x, int y) {
		String soapAction = soapActionURL +"Add";
		ObjectFactory obf = new ObjectFactory();
		Add add = obf.createAdd();
		add.setIntA(x);
		add.setIntB(y);
		
		log.info("adding two numbers:"+x+" and "+ y);

		AddResponse response =  (AddResponse)getWebServiceTemplate().marshalSendAndReceive(add, new WebServiceMessageCallback() {
			
			@Override
			public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
				// TODO Auto-generated method stub
				((SoapMessage)message).setSoapAction(soapAction);
				
			}
		});
		          
		return response.getAddResult(); 
	}
}
