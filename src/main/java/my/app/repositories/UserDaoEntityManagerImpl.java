package my.app.repositories;

import my.app.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("entityManagerImplementation")
@Transactional
public class UserDaoEntityManagerImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> list() {
        return entityManager
                .createQuery("Select user from User user", User.class)
                .getResultList();
    }

    @Override
    public Optional<User> get(Long id) {
        User user = entityManager.find(User.class, id);

        return Optional.of(user);
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user, Long id) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);

        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        TypedQuery<User> query = entityManager
                .createQuery("select u from User u where u.username = :username",
                User.class);
        query.setParameter("username", username);
        User user = null;

        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            return Optional.empty();
        }

        return Optional.of(user);
    }
}
