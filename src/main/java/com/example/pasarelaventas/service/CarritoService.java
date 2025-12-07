package com.example.pasarelaventas.service;

import com.example.pasarelaventas.model.ItemCarrito;
import com.example.pasarelaventas.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    private final List<ItemCarrito> carrito = new ArrayList<>();

    public void agregarProducto(Producto producto, Integer cantidad) {
        Optional<ItemCarrito> itemExistente = carrito.stream()
                .filter(item -> item.getProducto().getId().equals(producto.getId()))
                .findFirst();

        if (itemExistente.isPresent()) {
            ItemCarrito item = itemExistente.get();
            item.setCantidad(item.getCantidad() + cantidad);
        } else {
            carrito.add(new ItemCarrito(producto, cantidad));
        }
    }

    public void eliminarProducto(Long productoId) {
        carrito.removeIf(item -> item.getProducto().getId().equals(productoId));
    }

    public void actualizarCantidad(Long productoId, Integer cantidad) {
        carrito.stream()
                .filter(item -> item.getProducto().getId().equals(productoId))
                .findFirst()
                .ifPresent(item -> {
                    if (cantidad <= 0) {
                        eliminarProducto(productoId);
                    } else {
                        item.setCantidad(cantidad);
                    }
                });
    }

    public List<ItemCarrito> obtenerItems() {
        return new ArrayList<>(carrito);
    }

    public Double calcularTotal() {
        return carrito.stream()
                .mapToDouble(ItemCarrito::getSubtotal)
                .sum();
    }

    public Integer obtenerCantidadTotal() {
        return carrito.stream()
                .mapToInt(ItemCarrito::getCantidad)
                .sum();
    }

    public void limpiar() {
        carrito.clear();
    }

    public boolean estaVacio() {
        return carrito.isEmpty();
    }
}
