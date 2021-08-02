package services;

import daos.CustomerDAO;
import entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<CustomerEntity> getCustomers() {
        return this.customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void addCustomer(CustomerEntity customer) {
        this.customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public CustomerEntity getCustomer(int id) {
        return this.customerDAO.getCustomer(id);
    }
}
