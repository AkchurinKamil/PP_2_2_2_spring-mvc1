package web.dao;


import org.springframework.stereotype.Repository;

import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public void addUsers(User user) {
        entityManager.persist(user);
    }

    @Override
    public User userById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void update(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(userById(id));
    }
}
