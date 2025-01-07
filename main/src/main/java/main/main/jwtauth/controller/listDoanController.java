package main.main.jwtauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.service.listDoanservice;

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
}
