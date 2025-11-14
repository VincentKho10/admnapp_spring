package com.example.admnapp.services;

import com.example.admnapp.entities.Role;
import com.example.admnapp.repositories.RoleRepository;
import com.example.admnapp.util.ErrorHandler;

public class RoleServices{
    RoleRepository roleRepository;

    public RoleServices(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Iterable<Role> getAllRole(){
        try {
            Iterable<Role> role = roleRepository.findAll();
            return role;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Role getRole(Long id){
        try {
            Role role = roleRepository.findById(id).orElse(null);
            if(role==null){
                throw new ErrorHandler("role not found");
            }
            return role;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Role createRole(Role role){
        try {
            roleRepository.save(role);
            return role;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Role updateRole(Long id, Role role){
        try {
            Role targetrole = roleRepository.findById(id).orElse(null);
            if(targetrole==null){
                throw new ErrorHandler("role not found");
            }
            targetrole.setDescription(role.getDescription());
            targetrole.setRole_name(role.getRole_name());
            roleRepository.save(targetrole);
            return targetrole;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Role deleteRole(Long id){
        try {
            Role deleterole = roleRepository.findById(id).orElse(null);
            if(deleterole==null){
                throw new ErrorHandler("deleted role not found");
            }
            return deleterole;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
}
