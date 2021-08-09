package services;

import daos.IRoleDAO;
import daos.IUserDAO;
import entities.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pojos.MyUser;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IRoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    @Transactional
    public UserEntity findUserByUsername(String username){
        return userDAO.getUserByUsername(username);
    }

    @Override
    @Transactional
    public void save(MyUser myUser){
        UserEntity user = new UserEntity();

        user.setUsername(myUser.getUsername());
        user.setPassword(this.passwordEncoder.encode(myUser.getPassword()));
        user.setFirstName(myUser.getFirstName());
        user.setLastName(myUser.getFirstName());
        user.setEmail(myUser.getEmail());

        System.out.println("UserService, save(), user: " + user);

        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public boolean userExists(String username) {
        UserEntity user = this.userDAO.getUserByUsername(username);
        return user != null;
    }
}
