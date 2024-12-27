package main.main.exportData.Controller;


import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.services.DataofCusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataofCusController {
    @Autowired
    private DataofCusService dataofCusService;

    @GetMapping("/qldoan")
    @ResponseBody
    public List<DataofCusEntity> showTrips(Model model) {
        List<DataofCusEntity> DataofCus = dataofCusService.getAllTrips();
        return DataofCus; 
    }
}