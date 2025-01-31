package com.jve.seguridad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(HttpSession session) {
        // Aquí puedes añadir cualquier dato a la sesión
        String perra = "No me gusta como caza la perra";
               session.setAttribute("perra", perra);
        return "redirect:/home";
    }
}