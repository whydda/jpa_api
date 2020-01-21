package com.example.jpa_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping({"/", ""})
    public String welcome() {
        return "index.html";
    }
}
