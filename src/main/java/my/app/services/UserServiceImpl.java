package my.app.services;

import my.app.entities.User;
import my.app.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("entityManagerImplementation") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public Optional<User> get(Long id) {
        return userDao.get(id);
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user, Long id) {
        userDao.update(user, id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
