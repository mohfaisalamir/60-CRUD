package com.enigma.Soal1.service;

import com.enigma.Soal1.entity.OrderItem;
import com.enigma.Soal1.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    // Operasi Create
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Operasi Read
    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    // Operasi Update (tidak disediakan dalam contoh ini)
    // Operasi Delete
    public void deleteOrderItemById(Long id) {
        orderItemRepository.deleteById(id);
    }

    // Metode pencarian kustom (jika diperlukan)
    // Anda dapat menambahkan metode pencarian kustom di sini
}
