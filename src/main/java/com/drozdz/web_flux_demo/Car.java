package com.drozdz.web_flux_demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
@ToString
public class Car {
    private String id;
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }
}
