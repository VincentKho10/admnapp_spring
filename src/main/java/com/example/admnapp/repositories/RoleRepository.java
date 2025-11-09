package com.example.admnapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.admnapp.entities.Role;
import java.util.Optional;


public interface RoleRepository extends CrudRepository<Role, Long>{
    Optional<Role> findByRoleid(Long roleid);
}
