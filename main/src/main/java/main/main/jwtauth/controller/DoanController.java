
//package main.main.jwtauth.controller;
//
//import main.main.jwtauth.service.ExcelImportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api")
//public class DoanController {
//    @Autowired
//    private ExcelImportService excelImportService;
//
//    @PostMapping("/import")
//    public ResponseEntity<String> importExcel(@RequestParam("file") MultipartFile file) {
//        try {
//            excelImportService.importFromExcel(file);
//            return ResponseEntity.ok("Import thành công");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Lỗi khi import: " + e.getMessage());
//        }
//    }
//}
