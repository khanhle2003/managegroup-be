package main.main.Controller;

import main.main.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.main.Repo.UserRepo;
import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepo userRepository;


    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "form";

    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserEntity user) {
        userRepository.save(user);
        return "redirect:/api/form";
    }
        @GetMapping("/users")
    public String listUsers(Model model) {
        List<UserEntity> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "userList";
    }
}

