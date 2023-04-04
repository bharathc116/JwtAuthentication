package com.epicminds.jwttokenauth.demo.controller;

import com.epicminds.jwttokenauth.demo.model.UserEntity;
import com.epicminds.jwttokenauth.demo.repo.UserRepository;
import com.epicminds.jwttokenauth.demo.service.impl.UserAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserAddController {
    @Autowired
    UserAddService userAddService;
    @Autowired
    UserRepository userRepository;

    public UserAddController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/addUser")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        UserEntity userEntity1=new UserEntity();
        userEntity1.setUsername(userEntity.getUsername());
        userEntity1.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity1.setRoles(userEntity.getRoles());
        userAddService.addUser(userEntity1);
        return userEntity1;
    }


//    @PostMapping("/addUser")
//    public ResponseEntity<Object> createUser(@RequestBody UserEntity userEntity){
//        return new ResponseEntity<>(userAddService.addUser(userEntity), HttpStatus.CREATED);
//    }
}
