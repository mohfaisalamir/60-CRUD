package com.enigma.Soal1.repository;

import com.enigma.Soal1.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    // Metode pencarian berdasarkan nomor order
    Optional<PurchaseOrder> findByNumber(String number);

    // Metode pencarian berdasarkan tanggal
    List<PurchaseOrder> findByDate(java.time.LocalDate date);

    // Metode pencarian berdasarkan total amount di atas suatu nilai tertentu
    List<PurchaseOrder> findByTotalAmountGreaterThanEqual(java.math.BigDecimal amount);

}
