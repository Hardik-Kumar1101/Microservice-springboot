package com.microservice.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CurrencyExchangeServiceApplication8000 {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication8000.class, args);
	}

}
