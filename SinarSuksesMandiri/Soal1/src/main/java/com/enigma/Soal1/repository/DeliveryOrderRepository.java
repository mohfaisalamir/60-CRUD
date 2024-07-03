package com.enigma.Soal1.repository;

import com.enigma.Soal1.entity.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {

    // Cari semua DeliveryOrder berdasarkan status
    List<DeliveryOrder> findByStatus(String status);

    // Cari semua DeliveryOrder berdasarkan purchaseOrder id
    List<DeliveryOrder> findByPurchaseOrderId(Long purchaseOrderId);

    // Cari semua DeliveryOrder berdasarkan tanggal pengiriman
    List<DeliveryOrder> findByDeliveryDate(java.sql.Date deliveryDate);
}
