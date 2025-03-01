-- schema.sql
CREATE TABLE orders (
                        order_id VARCHAR(255) PRIMARY KEY,
                        user_id VARCHAR(255),
                        total_amount DOUBLE,
                        status VARCHAR(50),
                        created_at TIMESTAMP,
                        processed_at TIMESTAMP
);

CREATE TABLE orders_item_ids (
                                 order_order_id VARCHAR(255),
                                 item_ids VARCHAR(255),
                                 FOREIGN KEY (order_order_id) REFERENCES orders(order_id)
);