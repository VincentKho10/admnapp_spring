package com.example.admnapp.controllers;

import java.time.LocalDateTime;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.admnapp.entities.User;
import com.example.admnapp.repositories.UserRepository;
import com.example.admnapp.services.UserServices;
import com.example.admnapp.util.ErrorHandler;
import com.example.admnapp.util.ErrorResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserServices userServices;

    UserController(UserRepository userRepository) {
        this.userServices = new UserServices(userRepository);
    }

    @GetMapping("")
    public @ResponseBody Iterable<User> getAllUser() {
        Iterable<User> found_user = this.userServices.getAllUser();
        return found_user;
    }
    
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<User> getUser(@PathVariable Long id) {
        User found_user = this.userServices.getUser(id);
        if(found_user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found_user);
    }
    

    @PostMapping("/create")
    public @ResponseBody ResponseEntity<User> createUser(@RequestBody User entity) {
        User new_user = this.userServices.createUser(entity);
        if(new_user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new_user);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = this.userServices.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);        
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<User> delUser(@PathVariable Long id){
        User deletedUser = this.userServices.deleteUser(id);
        
        return ResponseEntity.ok(deletedUser);
    }

    @RestControllerAdvice
    public class GlobalExceptionHandler{

        private static final Logger logger = LoggerFactory.getLogger(UserController.class);

        @ExceptionHandler(ErrorHandler.class)
        public ResponseEntity<ErrorResponse> handleError(ErrorHandler ex){
            logger.error(ex.getMessage());
            ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Something went terribly wrong, please contact your admin");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}