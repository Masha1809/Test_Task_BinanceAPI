package com.example.demo.servises;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.CryptoPrice;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CryptosServise {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BINANCE_API_URL = "https://api.binance.com/api/v3/ticker/price";


    public CryptoPrice getPrice(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol can not be empty or null");
        }
        String apiUrlWithSymbol = BINANCE_API_URL + "?symbol=" + symbol;
        CryptoPrice response = restTemplate.getForObject(apiUrlWithSymbol, CryptoPrice.class);
        assert response != null;
        BigDecimal price = response.getPrice();
        price = price.setScale(8, RoundingMode.HALF_UP);
        response.setPrice(price);
        return response;
    }
}

