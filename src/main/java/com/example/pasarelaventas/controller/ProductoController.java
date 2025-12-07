package com.example.pasarelaventas.controller;

import com.example.pasarelaventas.model.Producto;
import com.example.pasarelaventas.model.Usuario;
import com.example.pasarelaventas.service.CarritoService;
import com.example.pasarelaventas.service.ProductoService;
import com.example.pasarelaventas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductoController {

    private final ProductoService productoService;
    private final CarritoService carritoService;

    @Autowired
    private UsuarioService usuarioService;

    public ProductoController(ProductoService productoService, CarritoService carritoService) {
        this.productoService = productoService;
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

    @GetMapping("/")
    public String index(Model model) {
        List<Producto> productos = productoService.obtenerTodos();
        model.addAttribute("productos", productos);
        model.addAttribute("cantidadCarrito", carritoService.obtenerCantidadTotal());
        agregarUsuarioAlModel(model);
        return "index";
    }

    @GetMapping("/productos")
    public String productos(@RequestParam(required = false) String categoria, Model model) {
        List<Producto> productos;
        if (categoria != null && !categoria.isEmpty()) {
            productos = productoService.obtenerPorCategoria(categoria);
        } else {
            productos = productoService.obtenerTodos();
        }
        model.addAttribute("productos", productos);
        model.addAttribute("categoriaSeleccionada", categoria);
        model.addAttribute("cantidadCarrito", carritoService.obtenerCantidadTotal());
        agregarUsuarioAlModel(model);
        return "productos";
    }

    @GetMapping("/producto/{id}")
    public String detalleProducto(@PathVariable Long id, Model model) {
        return productoService.obtenerPorId(id)
                .map(producto -> {
                    model.addAttribute("producto", producto);
                    model.addAttribute("cantidadCarrito", carritoService.obtenerCantidadTotal());
                    agregarUsuarioAlModel(model);
                    return "detalle-producto";
                })
                .orElse("redirect:/");
    }

    @PostMapping("/carrito/agregar")
    public String agregarAlCarrito(@RequestParam Long productoId, @RequestParam(defaultValue = "1") Integer cantidad) {
        productoService.obtenerPorId(productoId)
                .ifPresent(producto -> carritoService.agregarProducto(producto, cantidad));
        return "redirect:/carrito";
    }
}

