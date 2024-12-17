package main.main.home;

import lombok.AllArgsConstructor;
//import main.main.Entity.Topic;
//import main.main.Repo.TopicReponsitory;
import main.main.dto.UserDto;
//import main.main.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import main. main. home.HomeController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("userdto")
public class HomeController {
//    private CommentService commentService;
//    @Autowired
//    private TopicReponsitory topicReponsitory;
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
