package com.pluralsight.pluralsightdemo.controllers;

import com.pluralsight.pluralsightdemo.models.User;
import com.pluralsight.pluralsightdemo.models.UserDto;
import com.pluralsight.pluralsightdemo.repositories.UserRepository;
import com.pluralsight.pluralsightdemo.services.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Mapper mapper;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(mapper :: toUserDto).collect(Collectors.toList());
        // This logic should happen in the services folder and this controller should call a function written in there
    }

//    @PostMapping
//    @RequestMapping("compare/{id}")
//    public boolean comparePasswords(@RequestBody User user, @PathVariable Long id) {
//        User userInDb = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("No User Found"));
//
//        return passwordEncoder.matches(user.getPassword(), userInDb.getPassword());
//    }

    @PostMapping
    @RequestMapping("create")
    public void createUser(@RequestBody final User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        user.setActive(true);
        user.setUsername(user.getUsername());

        userRepository.save(user);
        userRepository.flush();
    }
}
