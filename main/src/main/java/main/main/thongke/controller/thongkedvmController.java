package main.main.thongke.controller;

import main.main.thongke.dto.ErrorResponse;
import main.main.thongke.dto.InvitationSearchRequest;
import main.main.thongke.dto.InvitationUnitResponse;
import main.main.thongke.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search/invitation")
public class thongkedvmController {

    @Autowired
    private thongkedvmService thongkeService;

    @PostMapping("/doanra")
    public ResponseEntity<?> searchByInvitationUnitsAndYear(@RequestBody InvitationSearchRequest request) {
        try {
    
            if (request.getInvitationUnits() == null || request.getInvitationUnits().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Please select at least one invitation unit"));
            }
            
            if (!request.getYear().matches("\\d{4}")) {
                return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Invalid year format. Please provide a 4-digit year."));
            }
            
            InvitationUnitResponse response = thongkeService.getDataByInvitationUnitsAndYear(
                request.getInvitationUnits(), 
                request.getYear()
            );
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            return ResponseEntity
                .internalServerError()
                .body(new ErrorResponse("Search failed: " + e.getMessage()));
        }
    }
}