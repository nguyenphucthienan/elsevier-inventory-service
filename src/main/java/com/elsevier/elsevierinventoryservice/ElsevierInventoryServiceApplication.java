package com.elsevier.elsevierinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ElsevierInventoryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElsevierInventoryServiceApplication.class, args);
  }
}
