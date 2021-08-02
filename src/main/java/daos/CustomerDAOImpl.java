package daos;

import entities.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCustomer(CustomerEntity customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(customer);
        session.getTransaction().commit();
    }

    @Override
    public CustomerEntity getCustomer(int i) {
        return null;
    }

    @Override
    public List<CustomerEntity> getCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query<CustomerEntity> query =
                session.createQuery(" from CustomerEntity order by lastName", CustomerEntity.class);

        return query.getResultList();
    }

    @Override
    public void updateCustomer(CustomerEntity customer) {

    }

    @Override
    public void deleteCustomer(int id) {

    }
}
