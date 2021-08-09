package services;

import entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import pojos.MyUser;

public interface IUserService extends UserDetailsService {
    UserEntity findUserByUsername(String username);

    void save(MyUser myUser);

    boolean userExists(String username);
}
