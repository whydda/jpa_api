package com.example.jpa_api.jpa.service;

import com.example.jpa_api.jpa.entity.Users;
import com.example.jpa_api.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Users regist(Users users) {
        List<Users> userList = userRepository.findAll();
        userRepository.save(users);
        return users;
    }
}
