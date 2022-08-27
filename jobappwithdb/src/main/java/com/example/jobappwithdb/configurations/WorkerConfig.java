package com.example.jobappwithdb.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.jobappwithdb.models.Worker;
import com.example.jobappwithdb.repositories.WorkerRepository;

@Configuration
public class WorkerConfig {
    @Autowired
    WorkerRepository repository;

    @Bean
    CommandLineRunner onStartUp() {
        return args -> {
            repository.addWorker(new Worker("Dimitar", "Manolev", "dimitar@emailcom", "mitkopas", "Manager", 20));
            repository.addWorker(new Worker("Nasence", "Lud", "nasence@emailcom", "nasencepas", "Manager", 20));
        };
    }

}
