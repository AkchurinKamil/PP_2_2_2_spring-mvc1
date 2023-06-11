package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String allPeople(Model model) {
        model.addAttribute("user", userService.getAllUser());
        return "/allPeople";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
       userService.addUsers(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.userById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}