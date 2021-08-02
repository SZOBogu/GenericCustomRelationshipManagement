package configs;

import daos.CustomerDAO;
import daos.CustomerDAOImpl;
import entities.CustomerEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.CustomerService;
import services.CustomerServiceImpl;

@Configuration
public class SpringConfig {
    @Bean
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(CustomerEntity.class)
                .buildSessionFactory();
    }

    @Bean
    public CustomerDAO customerDAO(){
        return new CustomerDAOImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }
}
