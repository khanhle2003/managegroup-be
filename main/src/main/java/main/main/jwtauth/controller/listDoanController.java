package main.main.jwtauth.controller;


import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.service.listDoanservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class listDoanController {
    @Autowired
    private listDoanservice ListDoanservice;

    @GetMapping("/auth/qldoan")
    @ResponseBody
    public List<listDoan> showTrips(Model model) {
        List<listDoan> listDoans = ListDoanservice.getAllTrips();
        return listDoans;
    }

    @GetMapping("/auth/qldoan/columns")
    @ResponseBody
    public List<Map<String, String>> showTripsColumns() {
        List<listDoan> listDoans = ListDoanservice.getAllTrips();

        // Tạo danh sách chứa các Map với 2 cột notificationDate và ngayNghiPhep
        List<Map<String, String>> result = new ArrayList<>();

        for (listDoan doan : listDoans) {
            Map<String, String> data = new HashMap<>();
            data.put("notificationDate", doan.getNotificationDate());
            data.put("ngayNghiPhep", doan.getNgayNghiPhep());
            result.add(data);
        }
        return result;
    }
}