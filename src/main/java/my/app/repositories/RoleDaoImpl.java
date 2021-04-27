package my.app.repositories;

import my.app.entities.Role;
import my.app.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        return entityManager
                .createQuery("select r from Role r", Role.class)
                .getResultList();
    }

    @Override
    public Optional<Role> get(Long id) {
        Role role = entityManager.find(Role.class, id);

        return Optional.of(role);
    }
}
