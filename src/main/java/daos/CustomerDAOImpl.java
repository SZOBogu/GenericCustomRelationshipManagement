package daos;

import entities.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCustomer(CustomerEntity customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public CustomerEntity getCustomer(int i) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        CustomerEntity customer = session.get(CustomerEntity.class, i);
        session.close();
        return customer;
    }

    @Override
    public List<CustomerEntity> getCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query<CustomerEntity> query =
                session.createQuery(" from CustomerEntity order by lastName", CustomerEntity.class);

        List<CustomerEntity> customerEntityList = query.getResultList();
        session.close();
        return customerEntityList;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();


        Query query = session.createQuery("delete from CustomerEntity where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
