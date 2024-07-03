package com.enigma.Soal1.service;

import com.enigma.Soal1.entity.PurchaseOrder;
import com.enigma.Soal1.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    // Operasi Create
    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    // Operasi Read
    public Optional<PurchaseOrder> getPurchaseOrderById(Long id) {
        return purchaseOrderRepository.findById(id);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    // Operasi Update (tidak disediakan dalam contoh ini)
    // Operasi Delete
    public void deletePurchaseOrderById(Long id) {
        purchaseOrderRepository.deleteById(id);
    }

}
