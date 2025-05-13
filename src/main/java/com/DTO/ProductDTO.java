package com.DTO;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    private double price;

    private Long categoryId;
    private String categoryName;

    private Set<Long> storeIds = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(Set<Long> storeIds) {
        this.storeIds = storeIds;
    }
}

