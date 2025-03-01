package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderRequest;
import com.example.ecommerce.exception.OrderCreationException;
import com.example.ecommerce.exception.OrderNotFoundException;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.repository.OrderRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    private final Map<String, Long> processingTimes = new ConcurrentHashMap<>();

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        startProcessing();
    }

    public Order createOrder(OrderRequest order) {
        try {
            Order newOrder = new Order();
            newOrder.setOrderId(UUID.randomUUID().toString());
            newOrder.setItemIds(order.getItemIds());
            newOrder.setUserId(order.getUserId());
            newOrder.setStatus("Pending");
            newOrder.setTotalAmount(order.getTotalAmount());
            newOrder.setCreatedAt(LocalDateTime.now());

            orderRepository.save(newOrder);
            orderQueue.offer(newOrder);

            return newOrder;
        } catch (Exception e) {
            throw new OrderCreationException("Error occurred while creating the order: " + e.getMessage());
        }
    }


    public String getOrderStatus(String orderId) {
        return orderRepository.findById(orderId)
                .map(Order::getStatus)
                .orElseThrow(() -> new OrderNotFoundException("Order with ID " + orderId + " not found"));
    }



    private void startProcessing() {
        new Thread(() -> {
            while (true) {
                try {
                    Order order = orderQueue.take();
                    order.setStatus("Processing");
                    orderRepository.save(order);

                    // Simulate processing time
                    Thread.sleep(1000);

                    order.setStatus("Completed");
                    order.setProcessedAt(LocalDateTime.now());
                    orderRepository.save(order);

                    processingTimes.put(order.getOrderId(),
                            Duration.between(order.getCreatedAt(), order.getProcessedAt()).toMillis());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    // Log the exception or rethrow if needed
                    System.err.println("Order processing was interrupted: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error occurred while processing order: " + e.getMessage());
                }
            }
        }).start();
    }


    public Map<String, Object> getMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        try {
            metrics.put("totalProcessed", orderRepository.count());
            metrics.put("avgProcessingTimeMs",
                    processingTimes.values().stream().mapToLong(Long::longValue).average().orElse(0.0));
            metrics.put("pendingCount", orderRepository.countByStatus("Pending"));
            metrics.put("processingCount", orderRepository.countByStatus("Processing"));
            metrics.put("completedCount", orderRepository.countByStatus("Completed"));
        } catch (Exception e) {
            metrics.put("error", "Error occurred while fetching metrics: " + e.getMessage());
        }
        return metrics;
    }
}