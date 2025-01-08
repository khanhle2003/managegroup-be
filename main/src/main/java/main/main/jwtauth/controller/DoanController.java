package main.main.jwtauth.controller;

import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.service.doanService;
import main.main.jwtauth.util.importUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DoanController {
    @Autowired
    doanService DoanService;

    @PostMapping("/excel/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file){
        String messgae = "";
        if(importUtils.hasExcelFormat(file)){
            try{
                DoanService.save(file);
                String message = "The Excel file is uploaded: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception exp) {
                String message = "The Excel file is not upload: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }
        String message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @GetMapping("/doan-list")
    public ResponseEntity<?> getDoans(){
        Map<String, Object> respDoan = new LinkedHashMap<String, Object>();
        List<listDoan> doanList = DoanService.findAll();
        if (!doanList.isEmpty()) {
            respDoan.put("status", 1);
            respDoan.put("data", doanList);
            return new ResponseEntity<>(respDoan, HttpStatus.OK);
        } else {
            respDoan.clear();
            respDoan.put("status", 0);
            respDoan.put("message", "Data is not found");
            return new ResponseEntity<>(respDoan, HttpStatus.NOT_FOUND);
        }
    }
}
