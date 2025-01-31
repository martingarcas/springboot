package com.jve.seguridad.controller;

import java.util.Enumeration;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.User;
import com.jve.seguridad.entity.User;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal User user,HttpSession session, Model model) {
        model.addAttribute("username", user.getUsername());
        session.setAttribute("perro","perraco");

        model.addAttribute("perro", session.getAttribute("perro"));
        return "home";
    }
}
