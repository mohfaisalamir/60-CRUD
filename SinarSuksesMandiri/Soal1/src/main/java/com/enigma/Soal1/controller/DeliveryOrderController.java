package com.enigma.Soal1.controller;

import com.enigma.Soal1.entity.DeliveryOrder;
import com.enigma.Soal1.service.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery-orders")
public class DeliveryOrderController {

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    @PostMapping
    public DeliveryOrder createDeliveryOrder(@RequestBody DeliveryOrder deliveryOrder) {
        return deliveryOrderService.saveDeliveryOrder(deliveryOrder);
    }

    @GetMapping("/{id}")
    public Optional<DeliveryOrder> getDeliveryOrderById(@PathVariable Integer id) {
        return deliveryOrderService.getDeliveryOrderById(id);
    }

    @GetMapping
    public List<DeliveryOrder> getAllDeliveryOrders() {
        return deliveryOrderService.getAllDeliveryOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteDeliveryOrderById(@PathVariable Integer id) {
        deliveryOrderService.deleteDeliveryOrderById(id);
    }

    @GetMapping("/status/{status}")
    public List<DeliveryOrder> getDeliveryOrdersByStatus(@PathVariable String status) {
        return deliveryOrderService.getDeliveryOrdersByStatus(status);
    }

    @GetMapping("/purchase-order/{purchaseOrderId}")
    public List<DeliveryOrder> getDeliveryOrdersByPurchaseOrderId(@PathVariable Long purchaseOrderId) {
        return deliveryOrderService.getDeliveryOrdersByPurchaseOrderId(purchaseOrderId);
    }

    @GetMapping("/delivery-date/{deliveryDate}")
    public List<DeliveryOrder> getDeliveryOrdersByDeliveryDate(@PathVariable java.sql.Date deliveryDate) {
        return deliveryOrderService.getDeliveryOrdersByDeliveryDate(deliveryDate);
    }
}
