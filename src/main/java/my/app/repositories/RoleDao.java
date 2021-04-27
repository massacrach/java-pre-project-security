package my.app.repositories;

import my.app.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {
    List<Role> getRoles();
    Optional<Role> get(Long id);
}
