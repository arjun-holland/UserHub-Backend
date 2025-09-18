package com.arjun.fullstack_backend.controller;

import com.arjun.fullstack_backend.exception.UserNotFoundException;
import com.arjun.fullstack_backend.model.User;
import com.arjun.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
// @CrossOrigin("http://localhost:3000") //to get the request from the frontend give its URL here
@CrossOrigin("https://user-hub-frontend-two.vercel.app/") //to get the request from the frontend give its URL here
public class UserController {
    @Autowired
     private UserRepository userRepository;

     @PostMapping("/user")
     User newUser(@RequestBody User newUser) {
         return  userRepository.save(newUser);
     }
    @GetMapping("/users")
    List<User> getAllUsers() {
         return  userRepository.findAll(); // Built-in method
    }
/*
⚙️ How the data gets saved/retrieved from MySQL:
Spring Boot autoconfiguration detects your MySQL setup (from application.properties).
It configures a JPA EntityManager and hooks it up to your User entity.
JpaRepository provides methods like findAll(), save(), etc. When you hit GET /users, your controller calls findAll(), which runs the SQL query:
* */

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return  userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
/*
This code tries to find the user by ID:
    ✅ If found: returns the user.
    ❌ If not found: throws UserNotFoundException.
* */

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}
