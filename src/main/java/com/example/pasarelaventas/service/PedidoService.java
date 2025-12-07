package com.example.pasarelaventas.service;

import com.example.pasarelaventas.model.ItemCarrito;
import com.example.pasarelaventas.model.Pedido;
import com.example.pasarelaventas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(Long usuarioId, List<ItemCarrito> items, String clienteNombre, String clienteEmail, 
                             String clienteDireccion, String metodoPago) {
        Pedido pedido = new Pedido();
        pedido.setUsuarioId(usuarioId);
        
        // Crear copias de los items y asociarlos al pedido
        List<ItemCarrito> itemsPedido = new ArrayList<>();
        for (ItemCarrito item : items) {
            ItemCarrito nuevoItem = new ItemCarrito();
            nuevoItem.setProducto(item.getProducto());
            nuevoItem.setCantidad(item.getCantidad());
            nuevoItem.setPedido(pedido);
            itemsPedido.add(nuevoItem);
        }
        
        pedido.setItems(itemsPedido);
        pedido.setTotal(items.stream()
                .mapToDouble(ItemCarrito::getSubtotal)
                .sum());
        pedido.setClienteNombre(clienteNombre);
        pedido.setClienteEmail(clienteEmail);
        pedido.setClienteDireccion(clienteDireccion);
        pedido.setMetodoPago(metodoPago);
        pedido.setEstado("CONFIRMADO");

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> obtenerPedidosPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }
}
