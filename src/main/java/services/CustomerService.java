package services;

import entities.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getCustomers();
    void addCustomer(CustomerEntity customer);
    CustomerEntity getCustomer(int id);
}
