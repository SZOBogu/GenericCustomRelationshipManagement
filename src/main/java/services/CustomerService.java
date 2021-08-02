package services;

import entities.CustomerEntity;

import java.util.List;

public interface CustomerService {
    public List<CustomerEntity> getCustomers();
    public void addCustomer(CustomerEntity customer);
}
