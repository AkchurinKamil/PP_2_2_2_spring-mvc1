package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.entity.User;

import java.util.List;
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    @Transactional
    public void addUsers(User user) {
        userDAO.addUsers(user);
    }

    @Override
    @Transactional
    public User userById(int id) {
        return userDAO.userById(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDAO.update(id,user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
