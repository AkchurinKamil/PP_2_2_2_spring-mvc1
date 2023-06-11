package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.entity.User;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public void addUsers(User user) {
        userDAO.addUsers(user);
    }

    @Override
    public User userById(int id) {
        return userDAO.userById(id);
    }

    @Override
    public void update(int id, User user) {
        userDAO.update(id,user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
