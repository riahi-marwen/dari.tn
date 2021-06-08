package com.esprit.dari;

import com.esprit.dari.services.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DariApplication {
@Autowired
    IBankService bankService;
    public static void main(String[] args) {
        SpringApplication.run(DariApplication.class, args);

    }

}
