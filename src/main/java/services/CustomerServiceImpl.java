package services;

import daos.ICustomerDAO;
import entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private ICustomerDAO ICustomerDAO;

    @Override
    @Transactional
    public List<CustomerEntity> getCustomers() {
        return this.ICustomerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void addCustomer(CustomerEntity customer) {
        this.ICustomerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public CustomerEntity getCustomer(int id) {
        return this.ICustomerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        this.ICustomerDAO.deleteCustomer(id);
    }
}
