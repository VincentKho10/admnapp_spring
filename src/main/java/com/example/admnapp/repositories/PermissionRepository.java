package com.example.admnapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.admnapp.entities.Permission;


public interface PermissionRepository extends CrudRepository<Permission, Long> {
    Optional<Permission> findByid(Long id);
}
