package com.example.admnapp.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.admnapp.entities.Permission;
import com.example.admnapp.repositories.PermissionRepository;
import com.example.admnapp.services.PermissionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@Controller
@RequestMapping("api/permissions")
public class PermissionController {
    
    private final PermissionService permissionService;

    PermissionController(PermissionRepository permissionRepository){
        this.permissionService = new PermissionService(permissionRepository);
    }

    @GetMapping("")
    public @ResponseBody Iterable<Permission> getAllPermission() {
        Iterable<Permission> permission = this.permissionService.getAllPermission();
        return permission;
    }
    
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Permission> getPermission(@PathVariable Long id) {
        Permission permission = this.permissionService.getPermission(id);
        if(permission != null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(permissionService.getPermission(id));
    }
    
    @PostMapping("/create")
    public @ResponseBody ResponseEntity<Permission> createPermission(@RequestBody Permission entity) {
        Permission permission = this.permissionService.createPermission(entity);
        if(permission != null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(permissionService.createPermission(permission));
    }
    
    @PutMapping("/update/{id}")
    public @ResponseBody ResponseEntity<Permission> updatePermission(@PathVariable Long id, @RequestBody Permission entity) {
        Permission permission = this.permissionService.updatePermission(id, entity);
        if(permission != null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(permissionService.updatePermission(id, permission));
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<Permission> deletePermission(@PathVariable Long id) {
        Permission permission = this.permissionService.deletePermission(id);
        if(permission != null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(permission);
    }
    
}
