package com.example.jobappwithdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobappwithdb.models.Worker;

@Repository
public interface IWorkerRepository extends JpaRepository<Worker, Long> {

    public Worker findByEmail(String email);

}
