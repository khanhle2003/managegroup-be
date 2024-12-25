package main.main.jwtauth.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadUserList() throws IOException {
        // Đọc file template DOCX
        try (XWPFDocument document = new XWPFDocument(new FileInputStream("C:\\Users\\Admin\\Desktop\\New folder (4)\\managegroup-be-main\\main\\src\\main\\resources\\templates\\don_xin_di_nuoc_ngoai_test.docx"))) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.write(outputStream);
            ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=userList.docx")
                    .contentLength(resource.contentLength())
                    .body(resource);
        }
    }
}
