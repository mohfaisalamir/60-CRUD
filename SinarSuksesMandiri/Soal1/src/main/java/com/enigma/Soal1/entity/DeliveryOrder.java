package com.enigma.Soal1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_delivery_order")
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery_order")
    private Integer idDeliveryOrder;

    @ManyToOne
    @JoinColumn(name = "id_purchase_order")
    private PurchaseOrder purchaseOrder;

    @Column(name = "delivery_date", nullable = false)
    private java.sql.Date deliveryDate;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    // Constructors, getters, and setters

    public DeliveryOrder(Integer idDeliveryOrder, PurchaseOrder purchaseOrder, java.sql.Date deliveryDate, String status) {
        this.idDeliveryOrder = idDeliveryOrder;
        this.purchaseOrder = purchaseOrder;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public DeliveryOrder() {
    }

    public Integer getIdDeliveryOrder() {
        return idDeliveryOrder;
    }

    public void setIdDeliveryOrder(Integer idDeliveryOrder) {
        this.idDeliveryOrder = idDeliveryOrder;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public java.sql.Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(java.sql.Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
