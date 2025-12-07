package com.example.imagenaleatoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ImagenController {

    // Lista de URLs de imágenes de ejemplo (puedes cambiarlas por tus propias imágenes)
    private final List<String> imagenes = new ArrayList<>();
    private final Random random = new Random();

    public ImagenController() {
        // Imágenes de ejemplo usando un servicio de imágenes placeholder
        imagenes.add("https://picsum.photos/400/300?random=1");
        imagenes.add("https://picsum.photos/400/300?random=2");
        imagenes.add("https://picsum.photos/400/300?random=3");
        imagenes.add("https://picsum.photos/400/300?random=4");
        imagenes.add("https://picsum.photos/400/300?random=5");
        imagenes.add("https://picsum.photos/400/300?random=6");
        imagenes.add("https://picsum.photos/400/300?random=7");
        imagenes.add("https://picsum.photos/400/300?random=8");
        imagenes.add("https://picsum.photos/400/300?random=9");
        imagenes.add("https://picsum.photos/400/300?random=10");
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/mostrar-imagen")
    public String mostrarImagen(@RequestParam("numero") Integer numero, Model model) {
        if (numero == null || numero < 0) {
            numero = 0;
        }
        
        // Usar el número como semilla para obtener una imagen "aleatoria" pero determinista
        Random rng = new Random(numero);
        int indice = rng.nextInt(imagenes.size());
        String imagenUrl = imagenes.get(indice);
        
        model.addAttribute("imagenUrl", imagenUrl);
        model.addAttribute("numeroIngresado", numero);
        
        return "resultado";
    }
}

