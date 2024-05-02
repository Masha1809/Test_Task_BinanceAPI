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
        log.info("Current price of " + symbol + " - " + cryptosServise.getPrice(symbol).getPrice());
        return cryptosServise.getPrice(symbol);
    }
}
