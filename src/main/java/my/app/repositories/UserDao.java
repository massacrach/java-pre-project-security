package my.app.repositories;

import my.app.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> list();
    Optional<User> get(Long id);
    void create(User user);
    void update(User user, Long id);
    void delete(Long id);
}
