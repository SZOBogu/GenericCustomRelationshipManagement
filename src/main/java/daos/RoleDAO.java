package daos;

import entities.RoleEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;

@Repository
@EnableTransactionManagement
public class RoleDAO implements IRoleDAO{

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public RoleEntity getRoleByName(String roleName){
        Session session = null;
        try{
            session = sessionFactory.getCurrentSession();
        }
        catch (HibernateException e){
            session = sessionFactory.openSession();
        }

        Query<RoleEntity> query = session.createQuery("from RoleEntity where name =: nameOfRole", RoleEntity.class);
        query.setParameter("nameOfRole", roleName);

        RoleEntity role = null;

        try{
            role = query.getSingleResult();
        }
        catch(Exception e){
            assert true; //do nothing
        }

        return role;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
