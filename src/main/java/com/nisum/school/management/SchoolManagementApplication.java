package com.nisum.school.management;

import com.google.cloud.spring.data.firestore.repository.config.EnableReactiveFirestoreRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "com.nisum.school.management.repository.school")
@EnableReactiveFirestoreRepositories(basePackages = "com.nisum.school.management.repository.user")
public class SchoolManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementApplication.class, args);
    }

}
