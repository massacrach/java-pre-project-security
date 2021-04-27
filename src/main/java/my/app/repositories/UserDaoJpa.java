package my.app.repositories;

import my.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDaoJpa extends JpaRepository<User, Long> {
    @Query("select u from User u join fetch u.roles where u.username = ?1")
    Optional<User> getUserByUsername(String username);
}
