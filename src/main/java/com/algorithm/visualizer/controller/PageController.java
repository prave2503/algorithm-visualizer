package com.algorithm.visualizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }
    
    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
