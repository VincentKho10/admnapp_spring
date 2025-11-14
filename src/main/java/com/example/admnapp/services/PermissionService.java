package com.example.admnapp.services;

import com.example.admnapp.entities.Permission;
import com.example.admnapp.entities.Role;
import com.example.admnapp.repositories.PermissionRepository;
import com.example.admnapp.util.ErrorHandler;

public class PermissionService{

    PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }
    
    public Iterable<Permission> getAllPermission(){
        try {
            Iterable<Permission> permission = permissionRepository.findAll();
            return permission;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Permission getPermission(Long id){
        try {
            Permission permission = permissionRepository.findById(id).orElse(null);
            if(permission==null){
                throw new ErrorHandler("role not found");
            }
            return permission;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Permission createPermission(Permission permission){
        try {
            permissionRepository.save(permission);
            return permission;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Permission updatePermission(Long id, Permission permission){
        try {
            Permission targetpermission = permissionRepository.findById(id).orElse(null);
            if(targetpermission==null){
                throw new ErrorHandler("role not found");
            }
            targetpermission.setName(permission.getName());
            permissionRepository.save(targetpermission);
            return targetpermission;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public Permission deletePermission(Long id){
        try {
            Permission deleterpermission = permissionRepository.findById(id).orElse(null);
            if(deleterpermission==null){
                throw new ErrorHandler("deleted role not found");
            }
            return deleterpermission;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
}
