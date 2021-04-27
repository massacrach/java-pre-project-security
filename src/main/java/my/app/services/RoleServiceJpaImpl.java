package my.app.services;

import my.app.entities.Role;
import my.app.repositories.RoleDaoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("RoleServiceJpaImpl")
public class RoleServiceJpaImpl implements RoleService {
    private final RoleDaoJpa roleDaoJpa;

    @Autowired
    public RoleServiceJpaImpl(RoleDaoJpa roleDaoJpa) {
        this.roleDaoJpa = roleDaoJpa;
    }

    @Override
    public List<Role> getRoles() {
        return roleDaoJpa.findAll();
    }

    @Override
    public Optional<Role> get(Long id) {
        return roleDaoJpa.findById(id);
    }
}
