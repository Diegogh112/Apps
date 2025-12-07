package com.example.pasarelaventas.service;

import com.example.pasarelaventas.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private Long nextId = 1L;

    public ProductoService() {
        inicializarProductos();
    }

    private void inicializarProductos() {
        productos.add(new Producto(nextId++, "Laptop HP", "Laptop HP 15.6 pulgadas, Intel Core i5, 8GB RAM, 256GB SSD", 599.99, "https://picsum.photos/300/300?random=1", 15, "Electrónica"));
        productos.add(new Producto(nextId++, "Mouse Inalámbrico", "Mouse inalámbrico ergonómico con sensor óptico de alta precisión", 29.99, "https://picsum.photos/300/300?random=2", 50, "Accesorios"));
        productos.add(new Producto(nextId++, "Teclado Mecánico", "Teclado mecánico RGB con switches azules, retroiluminado", 89.99, "https://picsum.photos/300/300?random=3", 30, "Accesorios"));
        productos.add(new Producto(nextId++, "Monitor 27 pulgadas", "Monitor Full HD 27 pulgadas, panel IPS, 75Hz", 249.99, "https://picsum.photos/300/300?random=4", 20, "Electrónica"));
        productos.add(new Producto(nextId++, "Auriculares Bluetooth", "Auriculares inalámbricos con cancelación de ruido activa", 129.99, "https://picsum.photos/300/300?random=5", 40, "Audio"));
        productos.add(new Producto(nextId++, "Webcam HD", "Cámara web Full HD 1080p con micrófono integrado", 59.99, "https://picsum.photos/300/300?random=6", 25, "Accesorios"));
        productos.add(new Producto(nextId++, "Tablet Samsung", "Tablet Android 10 pulgadas, 64GB, pantalla Full HD", 199.99, "https://picsum.photos/300/300?random=7", 18, "Electrónica"));
        productos.add(new Producto(nextId++, "Altavoz Bluetooth", "Altavoz portátil con sonido estéreo y batería de larga duración", 79.99, "https://picsum.photos/300/300?random=8", 35, "Audio"));
    }

    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos);
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Producto> obtenerPorCategoria(String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }
}

