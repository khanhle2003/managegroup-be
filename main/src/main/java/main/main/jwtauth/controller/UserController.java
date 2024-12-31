package main.main.jwtauth.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
public class UserController {

    @PostMapping("/export")
    public ResponseEntity<byte[]> exportWord(
            @RequestParam String fullName,
            @RequestParam String birthDate,
            @RequestParam String gender,
            @RequestParam String position) throws IOException {

        // Tạo một Map để lưu trữ dữ liệu từ form
        Map<String, String> data = new HashMap<>();
        data.put("fullName", fullName);
        data.put("birthDate", birthDate);
        data.put("gender", gender);
        data.put("position", position);

        // Tải file Word mẫu
        ClassPathResource template = new ClassPathResource("templates/don_xin_di_nuoc_ngoai_test.docx");
        XWPFDocument document;
        try (FileInputStream fis = new FileInputStream(template.getFile())) {
            document = new XWPFDocument(fis);
        }

        // Thay thế các placeholder trong Word bằng dữ liệu từ form
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            String paragraphText = paragraph.getText();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                String placeholder = "{" + entry.getKey() + "}";
                if (paragraphText.contains(placeholder)) {
                    String updatedText = paragraphText.replace(placeholder, entry.getValue());
                    for (XWPFRun run : paragraph.getRuns()) {
                        run.setText(updatedText, 0);
                    }
                }
            }
        }

        // Xuất file Word ra byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.write(outputStream);
        document.close();

        // Trả file Word về cho frontend
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.docx")
                .body(outputStream.toByteArray());
    }
}
