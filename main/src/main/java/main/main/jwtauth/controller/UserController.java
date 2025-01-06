package main.main.jwtauth.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.repository.UserRepository;
import main.main.jwtauth.repository.listDoanRepo;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private listDoanRepo listDoanRepo;

    @GetMapping("/export/{id}")
    public ResponseEntity<byte[]> exportWord(@PathVariable Long id) throws IOException {
        //in thông báo user not found nếu không tìm thấy id
        listDoan trip = listDoanRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // Thêm log để kiểm tra dữ liệu
        System.out.println("User data:");
        System.out.println("ID: " + trip.getId());
        System.out.println("fullName: " + trip.getFullName());
        System.out.println("birthDate: " + trip.getBirthDate());
        System.out.println("gender: " + trip.getGender());
        System.out.println("partyMember: " + trip.getPartyMember());
        System.out.println("jobTitle: " + trip.getJobTitle());
        System.out.println("unit: " + trip.getUnit());
        System.out.println("phoneNumber: " + trip.getPhoneNumber());
        System.out.println("email: " + trip.getEmail());
        System.out.println("country: " + trip.getCountry());
        System.out.println("sponsor: " + trip.getSponsor());
        System.out.println("startDate: " + trip.getStartDate());
        System.out.println("endDate: " + trip.getEndDate());
        System.out.println("tripPurpose: " + trip.getTripPurpose());
        System.out.println("selfFunded: " + trip.getSelfFunded());
        System.out.println("hospital: " + trip.getHospital());
        System.out.println("foreignTripCount: " + trip.getForeignTripCount());

        // truy cập vào database
        Map<String, String> data = new HashMap<>();
        data.put("fullName", trip.getFullName() != null ? trip.getFullName() : "");
        data.put("birthDate", trip.getBirthDate() != null ? trip.getBirthDate() : "");
        data.put("gender", trip.getGender() != null ? trip.getGender() : "");
        data.put("partyMember", trip.getPartyMember() != null ? trip.getPartyMember() : "");
        data.put("jobTitle", trip.getJobTitle() != null ? trip.getJobTitle() : "");
        data.put("unit", trip.getUnit() != null ? trip.getUnit() : "");
        data.put("phoneNumber", trip.getPhoneNumber() != null ? trip.getPhoneNumber() : "");
        data.put("email", trip.getEmail() != null ? trip.getEmail() : "");
        data.put("country", trip.getCountry() != null ? trip.getCountry() : "");
        data.put("sponsor", trip.getSponsor() != null ? trip.getSponsor() : "");
        data.put("startDate", trip.getStartDate() != null ? trip.getStartDate().toString() : "");
        data.put("endDate", trip.getEndDate() != null ? trip.getEndDate().toString() : "");
        data.put("tripPurpose", trip.getTripPurpose() != null ? trip.getTripPurpose() : "");
        data.put("selfFunded", trip.getSelfFunded() != null ? trip.getSelfFunded() : "");
        data.put("hospital", trip.getHospital() != null ? trip.getHospital() : "");
        data.put("foreignTripCount", trip.getForeignTripCount() != null ? trip.getForeignTripCount() : "");

        // Tải file Word mẫu
        ClassPathResource template = new ClassPathResource("templates/don_xin_di_nuoc_ngoai.docx");
        XWPFDocument document;
        try (FileInputStream fis = new FileInputStream(template.getFile())) {
            document = new XWPFDocument(fis);
        }

        // Thay thế các placeholder
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun run : runs) {
                String text = run.getText(0);
                if (text != null) {
                    for (Map.Entry<String, String> entry : data.entrySet()) {
                        String key = "{" + entry.getKey() + "}";
                        if (text.contains(key)) {
                            text = text.replace(key, entry.getValue());
                            run.setText(text, 0);
                        }
                    }
                }
            }
        }

        // Xuất file Word 
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.write(outputStream);
        document.close();

        // Trả file Word về cho frontend
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.docx")
                .body(outputStream.toByteArray());
    }
}
