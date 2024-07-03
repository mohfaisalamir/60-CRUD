package com.enigma.Soal1.service;

import com.enigma.Soal1.entity.DeliveryOrder;
import com.enigma.Soal1.repository.DeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryOrderService {

    @Autowired
    private DeliveryOrderRepository deliveryOrderRepository;

    public DeliveryOrder saveDeliveryOrder(DeliveryOrder deliveryOrder) {
        return deliveryOrderRepository.save(deliveryOrder);
    }

    public Optional<DeliveryOrder> getDeliveryOrderById(Integer id) {
        return deliveryOrderRepository.findById(id);
    }

    public List<DeliveryOrder> getAllDeliveryOrders() {
        return deliveryOrderRepository.findAll();
    }

    public void deleteDeliveryOrderById(Integer id) {
        deliveryOrderRepository.deleteById(id);
    }

    public List<DeliveryOrder> getDeliveryOrdersByStatus(String status) {
        return deliveryOrderRepository.findByStatus(status);
    }

    public List<DeliveryOrder> getDeliveryOrdersByPurchaseOrderId(Long purchaseOrderId) {
        return deliveryOrderRepository.findByPurchaseOrderId(purchaseOrderId);
    }

    public List<DeliveryOrder> getDeliveryOrdersByDeliveryDate(java.sql.Date deliveryDate) {
        return deliveryOrderRepository.findByDeliveryDate(deliveryDate);
    }
}
