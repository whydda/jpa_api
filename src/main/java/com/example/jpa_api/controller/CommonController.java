package com.example.jpa_api.controller;

import com.example.jpa_api.core.PasswordEncodeUtils;
import com.example.jpa_api.jpa.entity.Role;
import com.example.jpa_api.jpa.entity.Users;
import com.example.jpa_api.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-01-13
 * Time: 오후 4:49
 */
@RestController
public class CommonController {

    @Autowired
    private UserService userService;

    @GetMapping("/regist")
    public ResponseEntity<Map<String, Object>> regist(@ModelAttribute Users users){
        Map<String, Object> params = new HashMap<>();
        Users users1 = new Users("whydda", PasswordEncodeUtils.encodePassword("password"), "변진환", Role.ROLE_USER, LocalDateTime.now());
        userService.create(users1);

        Users users2 = new Users("whydda2", PasswordEncodeUtils.encodePassword("password"), "변진환2", Role.ROLE_USER, LocalDateTime.now());
        userService.create(users2);
        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> login(@ModelAttribute Users users){
        Map<String, Object> params = new HashMap<>();
        params.put("A", "A");
        params.put("B", "B");
        params.put("C", "C");
        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    @GetMapping("/user/list")
    public ResponseEntity<List<Users>> getUserList(@ModelAttribute Users users){
        List<Users> userList = userService.selectUserList();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
