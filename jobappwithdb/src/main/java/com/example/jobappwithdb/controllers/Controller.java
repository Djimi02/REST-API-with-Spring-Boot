package com.example.jobappwithdb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobappwithdb.models.Worker;
import com.example.jobappwithdb.services.WorkerService;

@RestController
public class Controller {

    @Autowired
    WorkerService service;

    @PostMapping("/worker/add")
    public void addWorker(@RequestBody Worker worker) {
        service.addWorker(worker);
    }

    @GetMapping("/workers")
    public List<Worker> listAllWorkers() {
        return service.listAllWorkers();
    }

    @GetMapping("/worker/getbyid/{id}")
    public Optional<Worker> findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/worker/getbyemail/{email}")
    public Worker findByEmail(@PathVariable(value = "email") String email) {
        return service.findByEmail(email);
    }

    @GetMapping("/worker")
    public String worker() {
        return "Hello Worker";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin";
    }

    @DeleteMapping("/worker/deletebyid/{id}")
    public String deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return "Worker with id " + id + " has been deleted";
    }

    @PutMapping("/worker/updatebyid/{id}")
    public String updateById(@PathVariable(value = "id") Long id, @RequestBody Worker newWorker) {
        service.updateById(id, newWorker);
        return "Worker with id " + id + " has been updated";
    }
}
