package com.ies.guiaelectrica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ies.guiaelectrica.repositories.ProductoRepository;
import com.ies.guiaelectrica.repositories.GuiaRepository;
import com.ies.guiaelectrica.repositories.NormativaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class PublicController {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private GuiaRepository guiaRepository;
    @Autowired
    private NormativaRepository normativaRepository;

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "productos";
    }

    @GetMapping("/guias")
    public String guias(Model model) {
        model.addAttribute("guias", guiaRepository.findAll());
        return "guias";
    }

    @GetMapping("/normativas")
    public String normativas(Model model) {
        model.addAttribute("normativas", normativaRepository.findAll());
        return "normativas";
    }

    @GetMapping("/calculadora")
    public String calculadora() {
        return "calculadora";
    }
}
