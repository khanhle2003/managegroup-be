package main.main.jwtauth.controller;

import io.jsonwebtoken.io.IOException;
import main.main.jwtauth.service.ExcelImportService1;
import main.main.jwtauth.service.importExcelNotDoanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class importExcelControllerNew {
    @Autowired
    private ExcelImportService1 excelImportService1;
    private importExcelNotDoanVienService importExcelNotDoanVien;

    @PostMapping("/import1")
    public ResponseEntity<String> importExcel1(@RequestParam("file") MultipartFile file) {
        try {
            excelImportService1.importFromExcel(file);
            return ResponseEntity.ok("Import thành công");
        } catch (IOException | java.io.IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi import: " + e.getMessage());
        }
    }

    @PostMapping("/importNull")
    public ResponseEntity<String> importNull(@RequestParam("file") MultipartFile file) {
        try {
            importExcelNotDoanVien.importFromExcel(file);
            return ResponseEntity.ok("Import thành công");
        } catch (IOException | java.io.IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi import: " + e.getMessage());
        }
    }
}
