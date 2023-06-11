package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();
    public void addUsers(User user);

    public User userById(int id);

    public void update(int id, User user);

    public void delete(int id);
}
