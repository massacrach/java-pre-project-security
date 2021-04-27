package my.app.repositories;

import my.app.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDaoJpa extends JpaRepository<Role, Long> {
}
