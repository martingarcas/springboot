package com.jve.primera.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jve.primera.models.Alumno;

@Controller
public class AlumnoController {

    private List<Alumno> alumnos = new ArrayList<>();

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "formulario-registro";
    }

    @PostMapping("/registro")
    public String registrarAlumno(@ModelAttribute Alumno alumno) {
        alumnos.add(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/alumnos")
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnos);
        return "alumnos";
    }
	
}
