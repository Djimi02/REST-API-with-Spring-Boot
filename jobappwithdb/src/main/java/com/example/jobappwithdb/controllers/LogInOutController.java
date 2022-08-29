package com.example.jobappwithdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobappwithdb.models.Worker;
import com.example.jobappwithdb.services.WorkerService;

@RestController
@RequestMapping("/")
public class LogInOutController {
    @Autowired
    WorkerService service;

    @PostMapping("/register")
    public void addWorker(@RequestBody Worker worker) {
        service.addWorker(worker);
    }
}
