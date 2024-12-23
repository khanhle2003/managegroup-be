package main.main.jwtauth.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.main.jwtauth.model.User;
import main.main.jwtauth.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> downloadUserList() throws IOException {
        List<User> users = userService.findAllUsers();

        // Đọc file template DOCX
        try (XWPFDocument document = new XWPFDocument(new FileInputStream("src/main/resources/templates/don_xin_di_nuoc_ngoai.docx"))) {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.createRun().setText("Danh sách người dùng:");

            for (User user : users) {
                paragraph.createRun().setText("ID: " + user.getId() + ", Tên: " + user.getUsername() + ", Email: " + user.getEmail());
            }

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
