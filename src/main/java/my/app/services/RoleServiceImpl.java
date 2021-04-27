package my.app.services;

import my.app.entities.Role;
import my.app.repositories.RoleDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("RoleServiceEntityManagerImpl")
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public Optional<Role> get(Long id) {
        return this.roleDao.get(id);
    }
}
