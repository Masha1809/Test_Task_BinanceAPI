package com.example.demo.models;


import lombok.*;
import java.math.BigDecimal;

@Data
@Getter
@Setter
public class CryptoPrice {
    private String symbol;
    private BigDecimal price;
}
