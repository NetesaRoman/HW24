package com.example.hw24.model;


import lombok.Value;

/*
 *
 * @author Roman Netesa
 *
 */
@Value
public class Product {
    int id;
    String name;
    double price;

    public void showInfo(){
        System.out.println("ID: " + id + " Name: " + name + " Price: " + price + " USD;");
    }
}
