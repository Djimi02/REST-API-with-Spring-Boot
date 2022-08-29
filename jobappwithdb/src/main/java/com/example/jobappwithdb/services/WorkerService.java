package com.example.jobappwithdb.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jobappwithdb.models.Worker;
import com.example.jobappwithdb.repositories.WorkerRepository;

@Service
public class WorkerService implements UserDetailsService {

    @Autowired
    WorkerRepository repository;

    public void addWorker(Worker worker) {
        repository.addWorker(worker);
    }

    public List<Worker> listAllWorkers() {
        return repository.listAllWorkers();
    }

    public Worker findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Optional<Worker> findById(Long id) {
        return repository.findById(id);
    }

    public Worker findByUserName(String userName){
        return repository.findByUserName(userName);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void updateById(Long id, Worker newWorker) {
        repository.updateById(id, newWorker);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Worker worker = repository.findByUserName(userName);

        // if (worker == null) {
        //     throw new UsernameNotFoundException("User not found");
        // }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(worker.getRole()));
        System.out.println(Arrays.toString(authorities.toArray()));
        
        
        return new org.springframework.security.core.userdetails.User(worker.getUserName(), worker.getPassword(), authorities);
    }
}
