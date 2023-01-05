package com.example.hw24;

import com.example.hw24.model.Order;
import com.example.hw24.model.Product;
import com.example.hw24.repositories.OrderRepository;
import com.example.hw24.repositories.ProductRepository;
import com.example.hw24.service.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Scanner;

@RestController
@SpringBootApplication
public class Hw24Application {

    private static int count = 1;
    private OrderRepository or = new OrderRepository(new ArrayList<>());
    private Cart cart = new Cart(new ArrayList<Product>());
    @Autowired
    private ProductRepository pr;

    public static void main(String[] args) {
        SpringApplication.run(Hw24Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void started() {
        Scanner sc = new Scanner(System.in);
        int commandID = 1;

        while (commandID != 0) {
            pr.showAll();

            System.out.println("\n1 - add to cart");
            System.out.println("2 - delete from cart");
            System.out.println("3 - show cart");
            System.out.println("4 - create an order");
            System.out.println("5 - show orders");
            System.out.println("6 - show orders by id");
            System.out.println("7 - delete order by id");
            System.out.println("0 - exit");
            commandID = sc.nextInt();
            switch (commandID) {
                case 1:
                    addToRepo(cart);
                    break;
                case 2:
                    deleteFromRepo(cart);
                    break;
                case 3:
                    cart.showAll();
                    break;
                case 4:
                    createOrder();
                    break;
                case 5:
                    showOrders();
                    break;
                case 6:
                    showOrderByID();
                    break;
                case 7:
                    deleteOrderByID();
                    break;
                default:
                    System.out.println("Unknow command");
                    break;
            }
        }

    }

    public void addToRepo(Cart cart) {
        Scanner sc = new Scanner(System.in);
        int id;

        System.out.println("Enter product ID: ");
        id = sc.nextInt();

        cart.getProducts().add(pr.getByID(id));


    }

    public static void deleteFromRepo(Cart cart) {
        Scanner sc = new Scanner(System.in);
        int id;

        System.out.println("Enter product ID: ");
        id = sc.nextInt();

        cart.delete(id);
    }

    public void showOrders() {
        or.getOrders().stream().forEach(Order::showInfo);
    }

    public void createOrder() {
        Order newOrder;
        newOrder = new Order(count, cart.getProducts());
        or.getOrders().add(newOrder);

        count++;
        cart.getProducts().removeAll(cart.getProducts());

    }

    public void showOrderByID() {
        Scanner sc = new Scanner(System.in);
        int id;

        System.out.println("Enter order ID: ");
        id = sc.nextInt();

        for (Order o : or.getOrders()) {
            if (o.getId() == id) {
                o.showInfo();
            }
        }
    }

    public void deleteOrderByID() {
        Scanner sc = new Scanner(System.in);
        int id;

        System.out.println("Enter order ID: ");
        id = sc.nextInt();

        or.getOrders().removeIf(o -> o.getId() == id);
    }

    @GetMapping(value = "/orders")
    public String showOrdres() {
        StringBuilder sb = new StringBuilder();
        for (Order o : or.getOrders()) {
            sb.append(o.makeString());
        }
        return sb.toString();
    }

    @GetMapping("/order/{id}")
    public String showOrdresByID(@PathVariable Integer id) {
        String result = "";
        for (Order o : or.getOrders()) {
            if (o.getId() == id) {
                result = o.makeString();
            }
        }
        return result;
    }

}
