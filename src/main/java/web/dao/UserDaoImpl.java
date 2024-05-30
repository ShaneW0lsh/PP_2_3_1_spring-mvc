package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    // TODO use real data base with hibernate
    private List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(new User(0, "Bryan", 170, "Network Engineer"));
        userList.add(new User(1, "John Doe", 178, "Software Engineer"));
        userList.add(new User(2, "Jane Smith", 165, "Marketing Manager"));
        userList.add(new User(3, "Bob Johnson", 183, "Data Analyst"));
        userList.add(new User(4, "Alice Williams", 157, "Product Manager"));
        userList.add(new User(5, "Charlie Brown", 170, "UX Designer"));
        userList.add(new User(6, "Emily Davis", 168, "Technical Writer"));
        userList.add(new User(7, "Frank Miller", 180, "QA Engineer"));
        userList.add(new User(8, "Grace Wilson", 163, "DevOps Engineer"));
        userList.add(new User(9, "Harry Moore", 175, "Project Manager"));
        userList.add(new User(10, "Irene Taylor", 160, "Business Analyst"));
        userList.add(new User(11, "David", 175, "DevOps Engineer"));
    }

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userList;
    }

    @Override
    public User getUserById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
