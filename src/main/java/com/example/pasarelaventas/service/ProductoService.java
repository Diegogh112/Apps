package com.example.pasarelaventas.service;

import com.example.pasarelaventas.model.Producto;
import com.example.pasarelaventas.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @PostConstruct
    public void inicializarProductos() {
        // Solo inicializar si no hay productos en la BD
        if (productoRepository.count() == 0) {
            productoRepository.save(new Producto(null, "Laptop HP", "Laptop HP 15.6 pulgadas, Intel Core i5, 8GB RAM, 256GB SSD", 599.99, "https://picsum.photos/300/300?random=1", 15, "Electrónica"));
            productoRepository.save(new Producto(null, "Mouse Inalámbrico", "Mouse inalámbrico ergonómico con sensor óptico de alta precisión", 29.99, "https://picsum.photos/300/300?random=2", 50, "Accesorios"));
            productoRepository.save(new Producto(null, "Teclado Mecánico", "Teclado mecánico RGB con switches azules, retroiluminado", 89.99, "https://picsum.photos/300/300?random=3", 30, "Accesorios"));
            productoRepository.save(new Producto(null, "Monitor 27 pulgadas", "Monitor Full HD 27 pulgadas, panel IPS, 75Hz", 249.99, "https://picsum.photos/300/300?random=4", 20, "Electrónica"));
            productoRepository.save(new Producto(null, "Auriculares Bluetooth", "Auriculares inalámbricos con cancelación de ruido activa", 129.99, "https://picsum.photos/300/300?random=5", 40, "Audio"));
            productoRepository.save(new Producto(null, "Webcam HD", "Cámara web Full HD 1080p con micrófono integrado", 59.99, "https://picsum.photos/300/300?random=6", 25, "Accesorios"));
            productoRepository.save(new Producto(null, "Tablet Samsung", "Tablet Android 10 pulgadas, 64GB, pantalla Full HD", 199.99, "https://picsum.photos/300/300?random=7", 18, "Electrónica"));
            productoRepository.save(new Producto(null, "Altavoz Bluetooth", "Altavoz portátil con sonido estéreo y batería de larga duración", 79.99, "https://picsum.photos/300/300?random=8", 35, "Audio"));
        }
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> obtenerPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }
}

