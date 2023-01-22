package com.example.hw24;

import com.example.hw24.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
public class Hw24Application {

    @Autowired
    private MainController mainController ;

    public static void main(String[] args) {
        SpringApplication.run(Hw24Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void started() {
        mainController.start();

    }



}
