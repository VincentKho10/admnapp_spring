package com.example.admnapp.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import com.example.admnapp.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
    Optional<Role> findByid(Long id);
}
