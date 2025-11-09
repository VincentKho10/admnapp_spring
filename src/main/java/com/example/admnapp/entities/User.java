package com.example.admnapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;
    private String username;
    private String password;
    private String name;

    @ManyToOne
    @JoinColumn(name="roleid", nullable = false)
    private Role role;

    public User(String username, String password, String name, Role role){
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User(){};

    @Override
    public String toString() {
        return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", name=" + name
                + ", role=" + role + "]";
    }

    public Long getUserid() {
        return userid;
    }
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
