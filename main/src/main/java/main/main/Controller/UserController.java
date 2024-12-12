package main.main.Controller;

import main.main.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import main.main.Repo.UserRepo;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepository;
    
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "form";
    
    }
    @GetMapping("/save")
    public String saveUser(@ModelAttribute UserEntity user) {
        userRepository.save(user);
        return "redirect:/";
    
    }
}

