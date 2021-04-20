package my.app.services;

import my.app.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> list();
    Optional<User> get(Long id);
    void create(User user);
    void update(User user, Long id);
    void delete(Long id);
    Optional<User> getUserByUsername(String username);
}
