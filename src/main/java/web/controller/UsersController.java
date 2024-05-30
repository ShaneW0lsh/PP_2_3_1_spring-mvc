package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserDaoImpl userDao;

    @Autowired
    public UsersController(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}") //TODO don't use PathVariable
    public String showUserWithId(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userDao.getUserById(id));
        return "user-profile";
    }

    @GetMapping()
    public String showUsers(ModelMap model) {
        List<User> userList = userDao.listUsers();

        model.addAttribute("users", userList);

        return "users";
    }
}
