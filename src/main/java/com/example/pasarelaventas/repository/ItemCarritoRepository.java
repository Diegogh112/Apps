package com.example.pasarelaventas.repository;

import com.example.pasarelaventas.model.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {
}

