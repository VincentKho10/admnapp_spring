package com.example.admnapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.admnapp.entities.User;
import com.example.admnapp.repositories.UserRepository;
import com.example.admnapp.util.ErrorHandler;

@Service
public class UserServices{
    
    private UserRepository userRepository;

    public UserServices(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUser(){
        try {
            Iterable<User> user = userRepository.findAll();
            return user;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
    
    public User getUser(Long id){
        try {
            User found_user = userRepository.findById(id).orElse(null);
            return found_user;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public User createUser(User user){
        try {
            User newuser = userRepository.save(user);
            return newuser;
        } catch (DataIntegrityViolationException e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public User updateUser(Long id, User user){
        try {
            User updateduser = userRepository.findById(id).orElse(null);
            System.out.println(updateduser);
            if(updateduser==null){
                throw new ErrorHandler(id + " not found");
            }
            updateduser.setName(user.getName());
            updateduser.setPassword(user.getPassword());
            updateduser.setRole(user.getRole());
            updateduser.setUsername(user.getUsername());
            userRepository.save(updateduser);
            return updateduser;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }

    public User deleteUser(Long id){
        try {
            User deluser = userRepository.findById(id).orElse(null);
            userRepository.delete(deluser);
            return deluser;
        } catch (Exception e) {
            throw new ErrorHandler(e.getMessage());
        }
    }
}