package my.app.controllers;

import my.app.entities.User;
import my.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        List<User> users = userService.list();

        model.addAttribute("users", users);
        model.addAttribute("usersExist", users.size() > 0);

        return "users/index";
    }

    @GetMapping("/create")
    public String create() {
        return "users/create";
    }

    @PostMapping
    public String store(@RequestBody User user) {
        userService.create(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<User> user = userService.get(id);

        if (!user.isPresent()) {
            return "redirect:/users";
        }

        model.addAttribute("user", user);

        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String store(@PathVariable Long id, @RequestBody User user) {
        userService.update(user, id);

        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);

        return "redirect:/users";
    }
}
