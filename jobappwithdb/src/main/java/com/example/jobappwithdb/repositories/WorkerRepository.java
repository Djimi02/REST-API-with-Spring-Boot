package com.example.jobappwithdb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jobappwithdb.models.Worker;

@Repository
public class WorkerRepository {
    
    @Autowired
    IWorkerRepository repository;

    public void addWorker(Worker worker){
        repository.save(worker);
    }

    public List<Worker> listAllWorkers(){
        return repository.findAll();
    }

    public Optional<Worker> findById(Long id){
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new IllegalStateException("Worker with id " + id + " does not exists");
        }

        return repository.findById(id);
    }

    public Worker findByEmail(String email){
        if (repository.findByEmail(email) == null) {
            throw new IllegalStateException("Worker with email " + email + " does not exists");
        }
        else {
            return repository.findByEmail(email);
        }
    }

    public void deleteById(Long id){
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new IllegalStateException("Worker with id " + id + " does not exists");
        }

        repository.deleteById(id);
    }

    public void updateById(Long id, Worker newWorker){
        Worker oldWorker = repository.findById(id).orElseThrow(() -> new IllegalStateException("Worker with id " + id + " does not exists"));

        if (newWorker.getAge() >= 16){
            oldWorker.setAge(newWorker.getAge());
        }

        if (newWorker.getEmail() != null){
            oldWorker.setEmail(newWorker.getEmail());
        }

        if (newWorker.getFirstName() != null){
            oldWorker.setFirstName(newWorker.getFirstName());
        }

        if (newWorker.getLastName() != null){
            oldWorker.setLastName(newWorker.getLastName());
        }

        if (newWorker.getRole() != null){
            oldWorker.setRole(newWorker.getRole());
        }

        repository.save(oldWorker);
    }

}
