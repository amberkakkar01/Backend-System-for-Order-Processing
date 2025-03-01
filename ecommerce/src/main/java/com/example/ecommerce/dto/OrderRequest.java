package com.example.ecommerce.dto;

import java.util.List;

public class OrderRequest {
    private String userId;
    private List<String> itemIds;
    private Double totalAmount;

    // Default Constructor
    public OrderRequest() {}

    // Parameterized Constructor
    public OrderRequest(String userId, List<String> itemIds, Double totalAmount) {
        this.userId = userId;
        this.itemIds = itemIds;
        this.totalAmount = totalAmount;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    // Setters
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
