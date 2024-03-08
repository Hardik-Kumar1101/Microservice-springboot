package com.microservice.currencyconversionservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private Long quantity;
    private BigDecimal totalCalculatedAmount;
    private String environment;

    public CurrencyConversion() {
    }
    public CurrencyConversion(Long id, String from, String to , Long quantity, BigDecimal conversionMultiple, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }
}
