package com.example.pasarelaventas.controller;

import com.example.pasarelaventas.model.Usuario;
import com.example.pasarelaventas.service.CarritoService;
import com.example.pasarelaventas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarritoController {

    private final CarritoService carritoService;

    @Autowired
    private UsuarioService usuarioService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    private void agregarUsuarioAlModel(Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.isAuthenticated() && !auth.getName().equals("anonymousUser")) {
                String email = auth.getName();
                Usuario usuario = usuarioService.buscarPorEmail(email).orElse(null);
                model.addAttribute("usuario", usuario);
            }
        } catch (Exception e) {
            // Usuario no autenticado
        }
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        model.addAttribute("items", carritoService.obtenerItems());
        model.addAttribute("total", carritoService.calcularTotal());
        model.addAttribute("cantidadCarrito", carritoService.obtenerCantidadTotal());
        agregarUsuarioAlModel(model);
        return "carrito";
    }

    @PostMapping("/carrito/actualizar")
    public String actualizarCantidad(@RequestParam Long productoId, @RequestParam Integer cantidad) {
        carritoService.actualizarCantidad(productoId, cantidad);
        return "redirect:/carrito";
    }

    @PostMapping("/carrito/eliminar")
    public String eliminarProducto(@RequestParam Long productoId) {
        carritoService.eliminarProducto(productoId);
        return "redirect:/carrito";
    }
}

