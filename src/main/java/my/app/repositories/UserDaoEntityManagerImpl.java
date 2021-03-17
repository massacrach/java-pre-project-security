package my.app.repositories;

import my.app.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("entityManagerImplementation")
public class UserDaoEntityManagerImpl implements UserDao {
    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(User user, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
