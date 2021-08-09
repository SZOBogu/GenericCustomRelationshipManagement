package daos;

import entities.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO{

    private SessionFactory sessionFactory;

    @Override
    public UserEntity getUserByUsername(String username) {
        Session session = null;
        try{
            session = sessionFactory.getCurrentSession();
        }
        catch (HibernateException e){
            session = sessionFactory.openSession();
        }


        Query<UserEntity> query = session.createQuery("from UserEntity where username =: nameOfUser", UserEntity.class);
        query.setParameter("nameOfUser", username);

        System.out.println("Query: " + query);

        UserEntity user = null;

        try{
            user = query.getSingleResult();
        }
        catch(Exception e){
            assert true; //do nothing
        }
        return user;
    }

    @Override
    public void saveUser(UserEntity user) {
        System.out.println("UserDAO: saving user");
        Session session = null;
        try{
            session = sessionFactory.getCurrentSession();
        }
        catch (HibernateException e){
            session = sessionFactory.openSession();
        }

        session.saveOrUpdate(user);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
