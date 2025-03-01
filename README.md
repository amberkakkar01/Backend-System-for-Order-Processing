# Backend System for Order Processing

This API provides functionality to create orders, view order details, and check processing metrics. Built with Spring Boot, it offers a robust backend solution for order management.

## Features
- Create new orders with user and item details
- Retrieve order status and details
- View processing metrics including average processing time

## API Endpoints

### 1. Create Order
Creates a new order with the specified details.

**Request:**
```bash
curl -X POST http://localhost:8080/api/orders \
-H "Content-Type: application/json" \
-d '{
    "userId": "USER001",
    "itemIds": ["ITEM1", "ITEM2"],
    "totalAmount": 99.99
}'
```
**Response:**
```bash
{
    "orderId": "7e5591a1-ce71-4c4f-826c-2caffa95e135",
    "userId": "USER001",
    "itemIds": ["ITEM1", "ITEM2"],
    "totalAmount": 99.99,
    "status": "Processing",
    "createdAt": "2025-03-01T14:34:55.827879",
    "processedAt": null
}
```

### 2. Status Api
API to check the status of orders

**Request:**
```bash
curl -X GET http://localhost:8080/api/orders/7e5591a1-ce71-4c4f-826c-2caffa95e135
```
**Response:**
```bash
Completed
```

### 3. Get Order Metrics
Returns processing metrics for all orders.

**Request:**
```bash
curl -X GET http://localhost:8080/api/orders/metrics
```

**Response:**
```bash
{
    "avgProcessingTimeMs": 1217.0,
    "pendingCount": 0,
    "processingCount": 0,
    "totalProcessed": 3,
    "completedCount": 3
}
```

