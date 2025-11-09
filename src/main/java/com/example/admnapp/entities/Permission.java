package com.example.admnapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Permission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permissionid;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Role role;
    
    public Permission(Long permissionid, String name) {
        this.permissionid = permissionid;
        this.name = name;
    }

    public Permission() {
    }

    public Long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Permission [permissionid=" + permissionid + ", name=" + name + "]";
    }

}