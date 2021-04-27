package my.app.services;

import my.app.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getRoles();
    Optional<Role> get(Long id);
}
