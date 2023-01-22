package com.example.hw24.configuration;

import com.example.hw24.controller.MainController;
import com.example.hw24.model.Product;
import com.example.hw24.repositories.OrderRepository;
import com.example.hw24.repositories.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/*
 *
 * @author Roman Netesa
 *
 */
@Configuration
public class ShopConfiguration {
    @Bean
    public Product product(){
        return new Product(1, "Halo MCC", 10);
    }

    @Bean
    public Product product1(){
        return new Product(2, "Doom Eternal", 30);
    }

    @Bean
    public Product product2(){
        return new Product(3, "ULTRAKILL", 5.50);
    }

    @Bean
    public Product product3(){
        return new Product(4, "DUSK", 5.50);
    }

    @Bean
    public Product product4(){
        return new Product(5, "Bioshock", 25.50);
    }

    @Bean
    public Product product5(){
        return new Product(6, "Serious Sam", 10.25);
    }

    @Bean
    public Product product6(){
        return new Product(7, "GTFO", 30.25);
    }

    @Bean
    public Product product7(){
        return new Product(8, "Portal", 15.25);
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepository(new ArrayList<>());
    }

    @Bean
    public MainController mainController(){return new MainController();}

}
