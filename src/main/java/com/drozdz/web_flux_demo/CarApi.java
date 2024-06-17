package com.drozdz.web_flux_demo;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@AllArgsConstructor
public class CarApi {

    private final CarRepository carRepository;

    @GetMapping(name = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Car> getAll() {
        return carRepository.findAll().delayElements(Duration.ofSeconds(1));
    }
}
