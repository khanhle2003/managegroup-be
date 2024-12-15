package main.main.Controller;


import main.main.Entity.DataofCusEntity;
import main.main.services.DataofCusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DataofCusController {
    @Autowired
    private DataofCusService dataofCusService;

    @GetMapping("/trips")
    public String showTrips(Model model) {
        List<DataofCusEntity> DataofCus = dataofCusService.getAllTrips();
        model.addAttribute("trips", DataofCus);
        return "trips"; // Tên của file template Thymeleaf
    }
}