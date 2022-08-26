package com.example.jobappwithdb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobappwithdb.models.Worker;
import com.example.jobappwithdb.repositories.WorkerRepository;

@Service
public class WorkerService {
    
    @Autowired
    WorkerRepository repository;

    public void addWorker(Worker worker){
        repository.addWorker(worker);
    }

    public List<Worker> listAllWorkers(){
        return repository.listAllWorkers();
    }

    public Worker findByEmail(String email){
        return repository.findByEmail(email);
    }

    public Optional<Worker> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void updateById(Long id, Worker newWorker){
        repository.updateById(id, newWorker);
    }
}
