package com.example.pasarelaventas.controller;

import com.example.pasarelaventas.model.Pedido;
import com.example.pasarelaventas.model.Usuario;
import com.example.pasarelaventas.service.PedidoService;
import com.example.pasarelaventas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PerfilController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/perfil")
    public String verPerfil(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        Usuario usuario = usuarioService.buscarPorEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Pedido> pedidos = pedidoService.obtenerPedidosPorUsuario(usuario.getId());

        model.addAttribute("usuario", usuario);
        model.addAttribute("pedidos", pedidos);
        return "perfil";
    }
}

