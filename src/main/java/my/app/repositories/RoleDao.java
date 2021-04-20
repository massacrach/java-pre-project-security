package my.app.repositories;

import my.app.entities.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRoles();
    Role get(Long id);
}
