package com.example.pasarelaventas.service;

import com.example.pasarelaventas.model.ItemCarrito;
import com.example.pasarelaventas.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final List<Pedido> pedidos = new ArrayList<>();
    private Long nextId = 1L;

    public Pedido crearPedido(List<ItemCarrito> items, String clienteNombre, String clienteEmail, 
                             String clienteDireccion, String metodoPago) {
        Pedido pedido = new Pedido();
        pedido.setId(nextId++);
        pedido.setItems(new ArrayList<>(items));
        pedido.setTotal(items.stream()
                .mapToDouble(ItemCarrito::getSubtotal)
                .sum());
        pedido.setClienteNombre(clienteNombre);
        pedido.setClienteEmail(clienteEmail);
        pedido.setClienteDireccion(clienteDireccion);
        pedido.setMetodoPago(metodoPago);
        pedido.setEstado("CONFIRMADO");

        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> obtenerTodos() {
        return new ArrayList<>(pedidos);
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}

