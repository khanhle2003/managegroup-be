package main.main.thongke.controller;

import main.main.thongke.dto.*;
import main.main.thongke.service.thongkeService;
import main.main.thongke.service.thongkeService2;

import java.lang.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class thongkeController {

    @Autowired
    private thongkeService thongkeService;
    
    @Autowired
    private thongkeService2 thongkeService2;

    @PostMapping("/country")
    public ResponseEntity<?> searchByCountriesAndYear(@RequestBody SearchRequest request) {
        try {
            // Validate request
            if (request.getCountries() == null || request.getCountries().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Please select at least one country"));
            }
            
            if (!request.getYear().matches("\\d{4}")) {
                return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Invalid year format. Please provide a 4-digit year."));
            }
            
            MultiCountryYearResponse response = thongkeService.getDataByCountriesAndYear(
                request.getCountries(), 
                request.getYear()
            );
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            return ResponseEntity
                .internalServerError()
                .body(new ErrorResponse("Search failed: " + e.getMessage()));
        }
    }



    @PostMapping("/countrydoanra")
    public ResponseEntity<?> getCountryDetailsByYearAndCountries(@RequestBody SearchRequest request) {
        try {
            if (!request.getYear().matches("\\d{4}")) {
                return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Invalid year format. Please provide a 4-digit year."));
            }
            
            CountryDetailResponse response = thongkeService2.getDataByYearAndCountries(
                request.getYear(), 
                request.getCountries()
            );
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            return ResponseEntity
                .internalServerError()
                .body(new ErrorResponse("Search failed: " + e.getMessage()));
        }
    }



}