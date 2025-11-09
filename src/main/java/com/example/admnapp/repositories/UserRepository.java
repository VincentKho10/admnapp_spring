package com.example.admnapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.admnapp.entities.Role;
import com.example.admnapp.entities.User;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByUserid(Long userid);
    Iterable<User> findByName(String name);
    List<User> findByRole(Role role);
    Optional<User> findByUsername(String username);
}