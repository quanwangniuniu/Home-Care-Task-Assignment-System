package com.example.haolongoldmansystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportData {
    private String name;
    private String sourceCity;
    private String destinationCity;
    private String phone;
}
