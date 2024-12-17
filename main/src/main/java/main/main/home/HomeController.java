package main.main.home;

import lombok.AllArgsConstructor;
import main.main.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class HomeController {
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @GetMapping("/home")
    public String showHomeForm(@ModelAttribute("userdto") UserDto userDto, Model model){
//        List<Topic> topics = topicReponsitory.findAll();
//        model.addAttribute("topics",topics);
//        model.addAttribute("commentcount",commentService);

        return "/home";
    }
}
