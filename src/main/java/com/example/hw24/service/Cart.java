package com.example.hw24.service;

import com.example.hw24.model.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *
 * @author Roman Netesa
 *
 */
@Service
@RequiredArgsConstructor
@Scope("prototype")
public class Cart {
    @Getter
    private final List<Product> products;


    public void add(Product p) {
        products.add(p);
    }

    public void delete(int index) {
        for (Product p : products) {
            if (index == p.getId()) {
                products.remove(p);
                break;
            }
        }

    }

    public void delete(Product p) {
        products.remove(p);
    }

    public void showByID(int id) {
        boolean found = false;

        for (Product p : products) {
            if (id == p.getId()) {
                p.showInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found!");
        }
    }

    public void showAll() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        System.out.println("----------CART------------");
        for (Product p : products) {
            p.showInfo();
        }
        System.out.println("--------------------------");
    }

}
