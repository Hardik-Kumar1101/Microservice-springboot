package com.microservice.currencyconversionservice.controller;

import com.microservice.currencyconversionservice.dto.CurrencyConversion;
import com.microservice.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversions/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retriveConversionValue(@PathVariable String from, @PathVariable String to, @PathVariable Long quantity) {
        HashMap<String, String> uriVariables = new HashMap<String, String>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> response = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,
                uriVariables);
        CurrencyConversion currencyConversion = response.getBody();
        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity , currencyConversion.getConversionMultiple(), currencyConversion.getEnvironment());
    }

    @GetMapping("/currency-conversions-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retriveConversionValueByFeign(@PathVariable String from, @PathVariable String to, @PathVariable Long quantity) {
        CurrencyConversion currencyConversion = currencyExchangeProxy.retriveExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity , currencyConversion.getConversionMultiple(), currencyConversion.getEnvironment() +" "+ "feign");
    }
}
