package com.example.haolongoldmansystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private String name;
    private String phone;
    private double distance;
    private double price;
}
