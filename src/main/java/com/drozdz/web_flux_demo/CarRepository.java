package com.drozdz.web_flux_demo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository<Car,String> {
}
