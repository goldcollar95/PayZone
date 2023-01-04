package com.example.ecommerce.service;

import com.example.ecommerce.model.Order;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface OrderService {

    @NotNull Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}
