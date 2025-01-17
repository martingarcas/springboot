package com.jve.primera.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class WelcomeController {
	@GetMapping("/")
    public String holaMundo() {
        return "hola-mundo";
    }
}

