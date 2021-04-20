package my.app.services;

import my.app.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role get(Long id);
}
