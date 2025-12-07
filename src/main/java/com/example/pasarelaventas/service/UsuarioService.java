package com.example.pasarelaventas.service;

import com.example.pasarelaventas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final List<Usuario> usuarios = new ArrayList<>();
    private Long nextId = 1L;

    public UsuarioService() {
        // Usuario de prueba (opcional)
        // Usuario admin = new Usuario("Admin", "admin@test.com", "admin123", "Dirección Admin", "123456789");
        // admin.setId(nextId++);
        // usuarios.add(admin);
    }

    public Usuario registrarUsuario(String nombre, String email, String password, String direccion, String telefono) {
        // Verificar si el email ya existe
        if (buscarPorEmail(email).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario usuario = new Usuario(nombre, email, password, direccion, telefono);
        usuario.setId(nextId++);
        usuarios.add(usuario);
        return usuario;
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    public boolean validarCredenciales(String email, String password) {
        return buscarPorEmail(email)
                .map(usuario -> passwordEncoder.matches(password, usuario.getPassword()))
                .orElse(false);
    }

    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }
}

