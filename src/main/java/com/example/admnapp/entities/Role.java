package com.example.admnapp.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"role_name"}))
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleid;
    private String role_name;
    private String description;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "role_permission",
        joinColumns = @JoinColumn(name = "roleid"),
        inverseJoinColumns = @JoinColumn(name = "permission")
    )
    private Set<Permission> permissions = new HashSet<>();
    
    public Role() {
    }

    public Role(String role_name, String description) {
        this.role_name = role_name;
        this.description = description;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role [roleid=" + roleid + ", role_name=" + role_name + ", description=" + description + "]";
    } 
}
