package com.example.admnapp.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.admnapp.entities.Role;
import com.example.admnapp.repositories.RoleRepository;
import com.example.admnapp.services.RoleServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
@RequestMapping("api/role")
public class RoleController {
    
    private final RoleServices roleServices;

    RoleController(RoleRepository roleRepository){
        this.roleServices = new RoleServices(roleRepository);
    }

    @GetMapping("/")
    public @ResponseBody ResponseEntity<Iterable<Role>> getAllRole() {
        Iterable<Role> role = this.roleServices.getAllRole();
        return ResponseEntity.ok(role);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Role> getRole(@PathVariable Long id) {
        Role role = this.roleServices.getRole(id);
        if(role == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(role);
    }
    
    @PostMapping("/create")
    public @ResponseBody ResponseEntity<Role> createRole(@RequestBody Role entity) {
        Role role = this.roleServices.createRole(entity);
        return ResponseEntity.ok(role);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role entity) {
        Role role = this.roleServices.updateRole(id, entity);
        return ResponseEntity.ok(role);
    }
    
    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<Role> deleteRole(@PathVariable Long id) {
        Role role = this.roleServices.deleteRole(id);
        return ResponseEntity.ok(role);
    }
    
}
