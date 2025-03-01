package com.example.ecommerce.dto;

import java.time.LocalDateTime;

public class OrderResponse {
    private Long orderId;
    private Long userId;
    private String itemIds;
    private Double totalAmount;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;

    // Default Constructor
    public OrderResponse() {}

    // Parameterized Constructor
    public OrderResponse(Long orderId, Long userId, String itemIds, Double totalAmount,
                         String status, LocalDateTime createdAt, LocalDateTime processedAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemIds = itemIds;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
        this.processedAt = processedAt;
    }

    // Getters
    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getItemIds() {
        return itemIds;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    // Setters
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setItemIds(String itemIds) {
        this.itemIds = itemIds;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }
}
