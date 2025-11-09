package com.ies.guiaelectrica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import com.ies.guiaelectrica.repositories.ProductoRepository;
import com.ies.guiaelectrica.repositories.GuiaRepository;
import com.ies.guiaelectrica.repositories.NormativaRepository;
import com.ies.guiaelectrica.models.Producto;
import com.ies.guiaelectrica.models.Guia;
import com.ies.guiaelectrica.models.Normativa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @Autowired private ProductoRepository productoRepository;
    @Autowired private GuiaRepository guiaRepository;
    @Autowired private NormativaRepository normativaRepository;

    @GetMapping("/login")
    public String login() { return "admin/login"; }

    @GetMapping("/panel")
    public String panel(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("guias", guiaRepository.findAll());
        model.addAttribute("normativas", normativaRepository.findAll());
        return "admin/panel";
    }

    @PostMapping("/producto")
    public String crearProducto(@ModelAttribute Producto producto, @RequestParam MultipartFile imagen) throws IOException {
        if (!imagen.isEmpty()) {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
            String filename = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + filename);
            imagen.transferTo(filePath);
            producto.setImagenUrl("/uploads/" + filename);
        }
        productoRepository.save(producto);
        return "redirect:/admin/panel";
    }

    @PostMapping("/normativa")
    public String crearNormativa(@ModelAttribute Normativa normativa, @RequestParam MultipartFile pdf) throws IOException {
        if (!pdf.isEmpty()) {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
            String filename = System.currentTimeMillis() + "_" + pdf.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + filename);
            pdf.transferTo(filePath);
            normativa.setPdfUrl("/uploads/" + filename);
        }
        normativaRepository.save(normativa);
        return "redirect:/admin/panel";
    }

    @PostMapping("/guia")
    public String crearGuia(@ModelAttribute Guia guia, @RequestParam MultipartFile recurso) throws IOException {
        if (!recurso.isEmpty()) {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
            String filename = System.currentTimeMillis() + "_" + recurso.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + filename);
            recurso.transferTo(filePath);
            guia.setRecursoUrl("/uploads/" + filename);
        }
        guiaRepository.save(guia);
        return "redirect:/admin/panel";
    }
}
