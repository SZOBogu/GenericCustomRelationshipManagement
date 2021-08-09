package daos;

import entities.RoleEntity;

public interface IRoleDAO {
    RoleEntity getRoleByName(String roleName);
}
