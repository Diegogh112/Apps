package com.example.pasarelaventas.controller;

import com.example.pasarelaventas.model.Pedido;
import com.example.pasarelaventas.service.CarritoService;
import com.example.pasarelaventas.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {

    private final CarritoService carritoService;
    private final PedidoService pedidoService;

    public CheckoutController(CarritoService carritoService, PedidoService pedidoService) {
        this.carritoService = carritoService;
        this.pedidoService = pedidoService;
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        if (carritoService.estaVacio()) {
            return "redirect:/carrito";
        }
        model.addAttribute("items", carritoService.obtenerItems());
        model.addAttribute("total", carritoService.calcularTotal());
        model.addAttribute("cantidadCarrito", carritoService.obtenerCantidadTotal());
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

        Pedido pedido = pedidoService.crearPedido(
                carritoService.obtenerItems(),
                clienteNombre,
                clienteEmail,
                clienteDireccion,
                metodoPago
        );

        carritoService.limpiar();

        model.addAttribute("pedido", pedido);
        return "confirmacion";
    }
}

