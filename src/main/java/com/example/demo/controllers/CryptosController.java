package com.example.demo.controllers;

import com.example.demo.models.CryptoPrice;
import com.example.demo.servises.CryptosServise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@Slf4j
@RestController
public class CryptosController {

    private final CryptosServise cryptosServise;

    @GetMapping("/price/{symbol}")
    public CryptoPrice getPrice(@PathVariable String symbol) {
        CryptoPrice price = cryptosServise.getPrice(symbol);
        log.info("Current price for " + symbol + " - " + price.getPrice());
        return price;
    }
}
