package main.main.Controller.user_login_logout_registration;


import lombok.AllArgsConstructor;
import main.main.Entity.UserEntity;
import main.main.dto.UserDto;
import main.main.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class UserRegistrationController {
    private UserService userService;
    @ModelAttribute("userdto")
    public UserDto userRegistrationDto(){ return new UserDto();}
    @GetMapping("/registration")
    public String showRegistrationForm(){ return "/registration";}

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("userdto") UserDto userDto){
        if(userService.checkUserbyEmail(userDto.getEmail())){
            return "redirect:/registration?emailexist";
        }
        if(userDto.getPassword().equals(userDto.getCheckPass())==false){
            return "redirect:/registration?checkpass";
        }
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
