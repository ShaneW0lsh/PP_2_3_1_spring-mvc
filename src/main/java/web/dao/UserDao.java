package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();

    User getUserById(int id);
    void deleteUserById(int id);

    void updateUser(int id, User user);
}
