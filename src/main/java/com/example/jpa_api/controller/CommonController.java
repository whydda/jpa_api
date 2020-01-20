package com.example.jpa_api.controller;

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

import java.util.HashMap;
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

    @GetMapping(value = "") // 2
    public String homePage(Model model) {
        return "index"; // 4
    }

    @PostMapping("/test")
    public ResponseEntity<Map<String, Object>> login(@ModelAttribute Users users){
        Map<String, Object> params = new HashMap<>();
        params.put("A", "A");
        params.put("B", "B");
        params.put("C", "C");
        return new ResponseEntity<>(params, HttpStatus.OK);
    }
}
