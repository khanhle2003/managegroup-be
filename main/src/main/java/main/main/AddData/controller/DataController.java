package main.main.AddData.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.main.AddData.entity.Data;
import main.main.AddData.service2.FileService;
@RestController
public class DataController {
    @Autowired
    private FileService fileService;
    @PostMapping("/savedata")
    public ResponseEntity<?> saveData(@RequestBody Data data) {
        try {
            fileService.saveToNotepad(data);
            return ResponseEntity.ok().body("Lưu dữ liệu thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi: " + e.getMessage());
        }
    }
}
