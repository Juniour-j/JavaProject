package com.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PurchaseDTO {

    private Long id;

    @NotNull(message = "Customer ID is required")
    private Long customerId;
    private String customerName;

    @NotNull(message = "Product ID is required")
    private Long productId;
    private String productName;

    private LocalDate purchaseDate;
    public PurchaseDTO() {
    }


    public PurchaseDTO(Long id, Long customerId, Long productId, LocalDate purchaseDate) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}