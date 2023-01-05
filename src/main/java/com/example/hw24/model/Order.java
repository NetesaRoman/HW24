package com.example.hw24.model;

import lombok.Data;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/*
 *
 * @author Roman Netesa
 *
 */
@Data
public class Order {
    int id;
    LocalDateTime date;
    double price;
    List<Product> products = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public Order(int id, List<Product> products){
        this.id = id;
        this.date = LocalDateTime.now();

        double temp = 0;
        for (Product p : products){
            temp += p.getPrice();
            this.products.add(p);
        }
        price = temp;

    }

    public void showInfo(){
        System.out.println("--------------------------------------");
        System.out.println("Order-ID: " + id);
        System.out.println("Date:" + date.format(formatter));
        System.out.println("Products:");
        for(Product p : this.products){
            p.showInfo();
        }
        System.out.println("Total price: " + price);
        System.out.println("--------------------------------------");
    }

    public String makeString(){
        String result;
        result = "--------------------------------------\n"
                + "Order-ID: " + id +
                "\nDate:" + date.format(formatter)+
                "\n Total price: " + price + "--------------------------------------\n";

        return result;
    }

}
