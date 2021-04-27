package my.app.services;

import my.app.entities.User;
import my.app.repositories.UserDaoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("UserServiceJpaImpl")
public class UserServiceJpaImpl implements UserService {
    private final UserDaoJpa userDaoJpa;

    @Autowired
    public UserServiceJpaImpl(UserDaoJpa userDaoJpa) {
        this.userDaoJpa = userDaoJpa;
    }

    @Override
    public List<User> list() {
        return userDaoJpa.findAll();
    }

    @Override
    public Optional<User> get(Long id) {
        return userDaoJpa.findById(id);
    }

    @Override
    @Transactional
    public void create(User user) {
        userDaoJpa.save(user);
    }

    @Override
    @Transactional
    public void update(User user, Long id) {
        User existingUser = userDaoJpa.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRoles(user.getRoles());

        userDaoJpa.save(existingUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDaoJpa.deleteById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userDaoJpa.getUserByUsername(username);
    }
}
