package com.sistema.gerenciamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String viewDashboard() {
        return "index.html";
    }
}