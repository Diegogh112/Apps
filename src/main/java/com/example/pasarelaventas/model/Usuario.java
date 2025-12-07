package com.example.pasarelaventas.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String direccion;
    
    @Column(nullable = false)
    private String telefono;
    
    @ElementCollection
    @CollectionTable(name = "usuario_pedidos", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "pedido_id")
    private List<Long> pedidosIds;

    public Usuario() {
        this.pedidosIds = new ArrayList<>();
    }

    public Usuario(String nombre, String email, String password, String direccion, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pedidosIds = new ArrayList<>();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Long> getPedidosIds() {
        return pedidosIds;
    }

    public void setPedidosIds(List<Long> pedidosIds) {
        this.pedidosIds = pedidosIds;
    }

    public void agregarPedido(Long pedidoId) {
        if (this.pedidosIds == null) {
            this.pedidosIds = new ArrayList<>();
        }
        this.pedidosIds.add(pedidoId);
    }
}
