package com.enigma.Soal1.repository;

import com.enigma.Soal1.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // Metode pencarian berdasarkan nama item
    List<OrderItem> findByItemName(String itemName);

    // Metode pencarian berdasarkan nama item dan jumlah
    Optional<OrderItem> findByItemNameAndQuantity(String itemName, int quantity);

}
