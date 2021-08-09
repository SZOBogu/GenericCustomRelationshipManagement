package daos;

import entities.CustomerEntity;

import java.util.List;

public interface ICustomerDAO {
    void saveCustomer(CustomerEntity customer);
    CustomerEntity getCustomer(int i);
    List<CustomerEntity> getCustomers();
    void deleteCustomer(int id);
}
