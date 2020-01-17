package com.example.jpa_api.jpa.service;

import com.example.jpa_api.error.UserNotFoundException;
import com.example.jpa_api.jpa.entity.Users;
import com.example.jpa_api.jpa.message.MessageSourceService;
import com.example.jpa_api.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSourceService messageSourceService;

    @Transactional
    public Users create(Users users) {
        users.setLastLoginTime(LocalDateTime.now());
        userRepository.save(users);
        return users;
    }

    @Transactional
    public Users selectUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(messageSourceService.getMessage("user.not.exist")));
    }
}
