package com.grocery.sprint3;

import com.grocery.sprint3.repository.VisitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Configuration
public class GroceryVisitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroceryVisitsApplication.class, args);
    }

}
