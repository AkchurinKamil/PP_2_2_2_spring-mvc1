package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import web.entity.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String allUsers(Model model){
        List<User> allUsers = userService.getAllUser();
       model.addAttribute("allUsers", allUsers);
        return "user";
    }
    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user",user);

        return "user-info";
    }
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUsers(user);
        return "redirect:/";
    }

}
