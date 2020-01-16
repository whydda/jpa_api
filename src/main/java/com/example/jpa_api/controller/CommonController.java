package com.example.jpa_api.controller;

import com.example.jpa_api.jpa.entity.Users;
import com.example.jpa_api.jpa.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-01-13
 * Time: 오후 4:49
 */
@RestController
public class CommonController {

    private UserService userService;

    CommonController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "") // 2
    public String homePage(Model model) {
        return "index"; // 4
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Users users){
        //등록
        userService.regist(users);
        return "main";
    }
}
