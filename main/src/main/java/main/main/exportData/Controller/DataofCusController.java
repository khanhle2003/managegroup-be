package main.main.exportData.Controller;


import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.services.DataofCusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/dates")
    public List<Map<String, Object>> getDates() {
        String sql = "SELECT notificationDate, ngayNghiPhep FROM ten_bang_cu";
        return jdbcTemplate.queryForList(sql);
    }


}