package com.jve.seguridad.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPage(@AuthenticationPrincipal User user,HttpSession session, Model model) {
        return "admin";
    }
}
