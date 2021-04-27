package my.app.controllers;

import my.app.entities.User;
import my.app.services.RoleService;
import my.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/admin/users")
public class UsersController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UsersController(@Qualifier("UserServiceJpaImpl") UserService userService,
                           @Qualifier("RoleServiceJpaImpl") RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String list(Model model) {
        List<User> users = userService.list();

        model.addAttribute("users", users);
        model.addAttribute("usersExist", users.size() > 0);

        return "users/index";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("all_roles", roleService.getRoles());

        return "users/create";
    }

    @PostMapping
    public String store(@ModelAttribute("user") @Valid User user,
                        BindingResult bindingResult,
                        Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("all_roles", roleService.getRoles());

            return "users/create";
        }

        boolean isUsernameAlreadyInUse = userService.getUserByUsername(user.getUsername()).isPresent();

        if (isUsernameAlreadyInUse) {
            model.addAttribute("usernameError", true);
            model.addAttribute("usernameErrorText", "Username is already in use");
            model.addAttribute("all_roles", roleService.getRoles());

            return "users/create";
        }

        userService.create(user);

        return "redirect:/admin/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<User> user = userService.get(id);

        if (user.isEmpty()) {
            return "redirect:/admin/users";
        }

        model.addAttribute("user", user.get());
        model.addAttribute("all_roles", roleService.getRoles());

        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String store(@PathVariable Long id,
                        @ModelAttribute("user") @Valid User user,
                        BindingResult bindingResult,
                        Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("all_roles", roleService.getRoles());

            return "users/edit";
        }

        userService.update(user, id);

        return "redirect:/admin/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);

        return "redirect:/admin/users";
    }
}
