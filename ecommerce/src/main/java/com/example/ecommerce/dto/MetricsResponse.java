package com.example.ecommerce.dto;

public class MetricsResponse {
    private long totalOrdersProcessed;
    private double averageProcessingTime;
    private long pendingOrders;
    private long processingOrders;
    private long completedOrders;

    // No-args constructor
    public MetricsResponse() {}

    // Full Constructor
    public MetricsResponse(long totalOrdersProcessed, double averageProcessingTime, long pendingOrders, long processingOrders, long completedOrders) {
        this.totalOrdersProcessed = totalOrdersProcessed;
        this.averageProcessingTime = averageProcessingTime;
        this.pendingOrders = pendingOrders;
        this.processingOrders = processingOrders;
        this.completedOrders = completedOrders;
    }

    // Getters and Setters
    public long getTotalOrdersProcessed() { return totalOrdersProcessed; }
    public void setTotalOrdersProcessed(long totalOrdersProcessed) { this.totalOrdersProcessed = totalOrdersProcessed; }

    public double getAverageProcessingTime() { return averageProcessingTime; }
    public void setAverageProcessingTime(double averageProcessingTime) { this.averageProcessingTime = averageProcessingTime; }

    public long getPendingOrders() { return pendingOrders; }
    public void setPendingOrders(long pendingOrders) { this.pendingOrders = pendingOrders; }

    public long getProcessingOrders() { return processingOrders; }
    public void setProcessingOrders(long processingOrders) { this.processingOrders = processingOrders; }

    public long getCompletedOrders() { return completedOrders; }
    public void setCompletedOrders(long completedOrders) { this.completedOrders = completedOrders; }
}
