package com.drozdz.web_flux_demo;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class InitService {

    private final CarRepository carRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        carRepository.deleteAll()
                .thenMany(
                        Flux.just("Acura", "Alpine", "Aston Martin", "BMW", "Bentley", "Brabus", "Cadillac", "Citroen", "Cupra", "Ford", "Honda", "Hennessey", "Land Rover", "Lexus")
                ).map(name -> new Car(name))
                .flatMap(carRepository::save)
                .thenMany(carRepository.findAll())
                .subscribe(System.out::println);

        carRepository.save(new Car(("Porsche"))).subscribe();
    }
}
