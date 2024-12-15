package main.main.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @GetMapping
    public String showDashboard(Model model) {
        // Giả sử bạn lấy thông tin người dùng từ session hoặc token
//        model.addAttribute("user", user);
        return "dashboard"; // Trang template Thymeleaf
    }
}
