package main.main.AddData.controller;



import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.AddData.service2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/table2/doanvao")  // Thay đổi path để tránh xung đột
public class DoanvaoController {  // Đổi tên class

    @Autowired
    @Qualifier("doanRaTable2Service")  // Chỉ định rõ service cần inject
    private DoanVaoService doanRaService;

    @PostMapping(value = "/add", 
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoanRaEntity> addDoanRa(@RequestBody DoanRaEntity doanRa) {
        try {
            DoanRaEntity savedDoanRa = doanRaService.addDoanRa(doanRa);
            return new ResponseEntity<>(savedDoanRa, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}