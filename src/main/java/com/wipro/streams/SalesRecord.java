package com.wipro.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SalesRecord {

    private String product;
    private int quantity;
    private double price;

}
