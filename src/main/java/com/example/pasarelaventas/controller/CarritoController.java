package com.example.pasarelaventas.controller;

import com.example.pasarelaventas.service.CarritoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        model.addAttribute("items", carritoService.obtenerItems());
        model.addAttribute("total", carritoService.calcularTotal());
        model.addAttribute("cantidadCarrito", carritoService.obtenerCantidadTotal());
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

