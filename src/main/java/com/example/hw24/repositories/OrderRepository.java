package com.example.hw24.repositories;

import com.example.hw24.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *
 * @author Roman Netesa
 *
 */
@Service
public class OrderRepository {
    @Getter
    private final List<Order> orders;

    public OrderRepository(List<Order> orders) {
        this.orders = orders;
    }


}
