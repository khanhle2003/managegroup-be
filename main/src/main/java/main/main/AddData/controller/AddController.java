package main.main.AddData.controller;

import main.main.AddData.dto.request.AddDataDto;
import main.main.AddData.entity.Data;
import main.main.AddData.service2.DataAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddController {
    @Autowired
    private DataAddService dataService;

    @GetMapping("/getAll")
    List<Data> getAllData1116(){
        return dataService.getAllData();
    }
    @PostMapping("/add")
    Data addData(@RequestBody AddDataDto request){
        return dataService.addData(request);
    }
}
