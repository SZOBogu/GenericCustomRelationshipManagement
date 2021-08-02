package daos;

import entities.CustomerEntity;

import java.util.List;

public interface CustomerDAO {
    void saveCustomer(CustomerEntity customer);
    CustomerEntity getCustomer(int i);
    List<CustomerEntity> getCustomers();
    void updateCustomer(CustomerEntity customer);
    void deleteCustomer(int id);
}
