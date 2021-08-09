package configs;

import daos.*;
import entities.CustomerEntity;
import entities.RoleEntity;
import entities.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import services.CustomerService;
import services.CustomerServiceImpl;
import services.IUserService;
import services.UserService;

@Configuration
//@EnableTransactionManagement
@ComponentScan(basePackages = {"controllers", "configs", "services", "daos", "entities", "pojos", "aspects", "main"})
public class SpringConfig implements WebMvcConfigurer {

    @Bean
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(CustomerEntity.class)
                .addAnnotatedClass(RoleEntity.class)
                .addAnnotatedClass(UserEntity.class)
                .buildSessionFactory();
    }

//    @Bean
//    public ICustomerDAO iCustomerDAO(){
//        return new CustomerDAO();
//    }

//    @Bean
//    public IRoleDAO iRoleDAO() {return new RoleDAO();}
//
//    @Bean
//    public IUserService iUserService(){
//        return new UserService();
//    }

//    @Bean
//    public IUserDAO iUserDAO() {return new UserDAO();}

//    @Bean
//    public CustomerService customerService(){
//        return new CustomerServiceImpl();
//    }

//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//        return txManager;
//    }
}
