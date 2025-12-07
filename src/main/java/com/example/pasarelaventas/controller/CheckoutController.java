package com.example.pasarelaventas.controller;

import com.example.pasarelaventas.model.Pedido;
import com.example.pasarelaventas.model.Usuario;
import com.example.pasarelaventas.service.CarritoService;
import com.example.pasarelaventas.service.PedidoService;
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
public class CheckoutController {

    private final CarritoService carritoService;
    private final PedidoService pedidoService;

    @Autowired
    private UsuarioService usuarioService;

    public CheckoutController(CarritoService carritoService, PedidoService pedidoService) {
        this.carritoService = carritoService;
        this.pedidoService = pedidoService;
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

    @GetMapping("/checkout")
    public String checkout(Model model) {
        if (carritoService.estaVacio()) {
            return "redirect:/carrito";
        }
        model.addAttribute("items", carritoService.obtenerItems());
        model.addAttribute("total", carritoService.calcularTotal());
        model.addAttribute("cantidadCarrito", carritoService.obtenerCantidadTotal());
        agregarUsuarioAlModel(model);
        return "checkout";
    }

    @PostMapping("/checkout/procesar")
    public String procesarPedido(
            @RequestParam String clienteNombre,
            @RequestParam String clienteEmail,
            @RequestParam String clienteDireccion,
            @RequestParam String metodoPago,
            Model model) {

        if (carritoService.estaVacio()) {
            return "redirect:/carrito";
        }

        // Obtener usuario autenticado
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Usuario usuario = usuarioService.buscarPorEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Pedido pedido = pedidoService.crearPedido(
                usuario.getId(),
                carritoService.obtenerItems(),
                clienteNombre,
                clienteEmail,
                clienteDireccion,
                metodoPago
        );

        // Asociar pedido con usuario
        usuario.agregarPedido(pedido.getId());

        carritoService.limpiar();

        model.addAttribute("pedido", pedido);
        return "confirmacion";
    }
}

