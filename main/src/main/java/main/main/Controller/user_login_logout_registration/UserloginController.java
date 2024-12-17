package main.main.Controller.user_login_logout_registration;

import lombok.AllArgsConstructor;
import main.main.Entity.UserEntity;
import main.main.dto.UserDto;
import main.main.services.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class UserloginController {
    private UserService userService;
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/login")
    public String showLoginForm(){
        return "/login";
    }
    @PostMapping("/login")
    public String Login(@ModelAttribute("userdto") UserDto userDto, Model model){
        if(userService.checkUserbyEmail(userDto.getEmail())==false){
            return "redirect:/login?emailwrong";
        }
        UserEntity user = userService.getUserbyEmail(userDto.getEmail());
        if(user.getRole().equals("ADMIN")){
            return  "redirect:/admin_home";
        }
        if(userService.checkPasswordUser(userDto.getEmail(),userDto.getPassword())){
            return "redirect:/home?success";
        }

        return "redirect:/login?passwordwrong";
    }
}
