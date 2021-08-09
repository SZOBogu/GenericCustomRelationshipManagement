package daos;

import entities.UserEntity;

public interface IUserDAO {
    UserEntity getUserByUsername(String username);
    void saveUser(UserEntity user);
}
