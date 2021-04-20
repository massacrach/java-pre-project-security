package my.app.controllers;

import my.app.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class PersonalPage {
    @GetMapping
    public String getPersonalPage(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        model.addAttribute("id", user.getId());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("roles", user.getRoles());

        return "personal_page/index";
    }
}
