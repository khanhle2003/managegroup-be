package main.main.exportData.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.jsonwebtoken.io.IOException;
import main.main.exportData.services.ExcelImportService;
import main.main.jwtauth.service.ExcelImportService1;

@RestController
@RequestMapping("/api")
public class importController {
    @Autowired
    private ExcelImportService excelImportService;

    @PostMapping("/import")
    public ResponseEntity<String> importExcel(@RequestParam("file") MultipartFile file) {
        try {
            excelImportService.importFromExcel(file);
            return ResponseEntity.ok("Import thành công");
        } catch (IOException | java.io.IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi import: " + e.getMessage());
        }
    }


}
