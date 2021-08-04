package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"controllers", "entities", "configs", "daos", "aspects"})
public class BasicGenericCustomRelationShipManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicGenericCustomRelationShipManagementApplication.class, args);
    }

}
