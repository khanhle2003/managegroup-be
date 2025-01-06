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
        System.out.println("Full Name: " + trip.getFullName());
        System.out.println("Birth Date: " + trip.getBirthDate());
        System.out.println("Gender: " + trip.getGender());
        System.out.println("Position: " + trip.getPosition());
        // System.out.println("Leaving Count: " + trip.getLeavingCount());

        Map<String, String> data = new HashMap<>();
        data.put("fullName", trip.getFullName() != null ? trip.getFullName() : "");
        data.put("birthDate", trip.getBirthDate() != null ? trip.getBirthDate() : "");
        data.put("gender", trip.getGender() != null ? trip.getGender() : "");
        data.put("position", trip.getPosition() != null ? trip.getPosition() : "");

        // data.put("isMember", trip.getIsMember() != null ? trip.getIsMember() : "");
        // data.put("partyBranch", trip.getPartyBranch() != null ? trip.getPartyBranch() : "");
        // data.put("contractCheckbox", trip.getContractCheckbox() != null ? trip.getContractCheckbox() : "");
        // data.put("officialCheckbox", trip.getOfficialCheckbox() != null ? trip.getOfficialCheckbox() : "");
        // data.put("jobDescribtion", trip.getJobDescribtion() != null ? trip.getJobDescribtion() : "");
        data.put("jobTitle", trip.getJobTitle() != null ? trip.getJobTitle() : "");
        // data.put("jobUnit", trip.getJobUnit() != null ? trip.getJobUnit() : "");

        // data.put("phoneNumber", trip.getPhoneNumber() != null ? trip.getPhoneNumber() : "");
        // data.put("email", trip.getEmail() != null ? trip.getEmail() : "");
        data.put("country", trip.getCountry() != null ? trip.getCountry() : "");
        data.put("invitationUnit", trip.getInvitationUnit() != null ? trip.getInvitationUnit() : "");
        // data.put("startDate", trip.getStartDate() != null ? trip.getStartDate() : "");
        // data.put("endDate", trip.getEndDate() != null ? trip.getEndDate() : "");
        data.put("tripPurpose", trip.getTripPurpose() != null ? trip.getTripPurpose() : "");
        // data.put("purposeDetail", trip.getPurposeDetail() != null ? trip.getPurposeDetail() : "");
        // data.put("invitationCheckbox", trip.getInvitationCheckbox() != null ? trip.getInvitationCheckbox() : "");
        // data.put("selfFundedCheckbox", trip.getSelfFundedCheckbox() != null ? trip.getSelfFundedCheckbox() : "");
        // data.put("hospitalCheckbox", trip.getHospitalCheckbox() != null ? trip.getHospitalCheckbox() : "");
        data.put("foreignTripCount", trip.getForeignTripCount() != null ? trip.getForeignTripCount() : "");
        // data.put("leavingCount", trip.getLeavingCount() != null ? trip.getLeavingCount() : "");
        // data.put("alternative", trip.getAlternative() != null ? trip.getAlternative() : "");

        // Tải file Word mẫu
        ClassPathResource template = new ClassPathResource("templates/don_xin_di_nuoc_ngoai_test.docx");
        XWPFDocument document;
        try (FileInputStream fis = new FileInputStream(template.getFile())) {
            document = new XWPFDocument(fis);
        }

        // Thay thế các placeholder
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            List<XWPFRun> runs = paragraph.getRuns();
            for (int i = 0; i < runs.size(); i++) {
                String text = runs.get(i).getText(0);
                if (text != null) {
                    // Kiểm tra và thay thế placeholder trong mỗi run
                    for (Map.Entry<String, String> entry : data.entrySet()) {
                        String key = "{" + entry.getKey() + "}";
                        if (text.contains(key)) {
                            // In ra thông tin
                            System.out.println("Found placeholder: " + key);
                            System.out.println("Replacing with value: " + entry.getValue());

                            text = text.replace(key, entry.getValue());
                            runs.get(i).setText(text, 0);
                        }
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
