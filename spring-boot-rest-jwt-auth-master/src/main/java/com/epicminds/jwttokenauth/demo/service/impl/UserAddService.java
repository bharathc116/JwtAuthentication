package com.epicminds.jwttokenauth.demo.service.impl;

import com.epicminds.jwttokenauth.demo.model.UserEntity;
import com.epicminds.jwttokenauth.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddService {

    @Autowired
    UserRepository userRepository;

    public UserEntity addUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }


}
