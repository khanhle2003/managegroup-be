package main.main.jwtauth.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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
import main.main.jwtauth.repository.listDoanRepo;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
public class UserController {


    @Autowired
    private listDoanRepo listDoanRepo;

    @GetMapping("/export/{id}")
    public ResponseEntity<byte[]> exportWord(@PathVariable Long id) throws IOException {
        listDoan trip = listDoanRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        Map<String, String> data = new HashMap<>();
        data.put("full_name", trip.getFullName() != null ? trip.getFullName() : "");
        data.put("birth_date", trip.getBirthDate() != null ? trip.getBirthDate() : "");
        data.put("gender", trip.getGender() != null ? trip.getGender() : "");
        data.put("party_member", trip.getPartyMember() != null ? trip.getPartyMember() : "");
        data.put("job_title", trip.getJobTitle() != null ? trip.getJobTitle() : "");
        data.put("unit", trip.getUnit() != null ? trip.getUnit() : "");
        data.put("phone_number", trip.getPhoneNumber() != null ? trip.getPhoneNumber() : "");
        data.put("email", trip.getEmail() != null ? trip.getEmail() : "");
        data.put("country", trip.getCountry() != null ? trip.getCountry() : "");
        data.put("sponsor", trip.getSponsor() != null ? trip.getSponsor() : "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        data.put("start_date", trip.getStartDate() != null ? trip.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter) : "");
        data.put("end_date", trip.getEndDate() != null ? trip.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter) : "");
        data.put("trip_purpose", trip.getTripPurpose() != null ? trip.getTripPurpose() : "");
        data.put("self_funded", trip.getSelfFunded() != null ? trip.getSelfFunded() : "");
        data.put("hospital", trip.getHospital() != null ? trip.getHospital() : "");
        data.put("foreign_trip_count", trip.getForeignTripCount() != null ? trip.getForeignTripCount() : "");
        data.put("party_branch", trip.getPartyBranch() != null ? trip.getPartyBranch() : "");
        data.put("party_position", trip.getPartyPosition() != null ? trip.getPartyPosition() : "");
        data.put("employee", trip.getEmployee() != null ? trip.getEmployee() : "");
        data.put("job_name", trip.getJobName() != null ? trip.getJobName() : "");
        data.put("rest_count", trip.getRestCount() != null ? trip.getRestCount() : "");
        data.put("alternative", trip.getAlternative() != null ? trip.getAlternative() : "");
        data.put("submit_day", trip.getSubmitDay() != null ? trip.getSubmitDay() : "");
        data.put("invitation_unit", trip.getInvitationUnit() != null ? trip.getInvitationUnit() : "");
        System.out.println("Replacement values:");
        data.forEach((key, value) -> System.out.println(key + ": " + value));

        ClassPathResource template = new ClassPathResource("templates/don_xin_di_nuoc_ngoai.docx");
        XWPFDocument document;
        try (FileInputStream fis = new FileInputStream(template.getFile())) {
            document = new XWPFDocument(fis);
        }

        for (XWPFParagraph paragraph : document.getParagraphs()) {
            String paragraphText = paragraph.getText();
            System.out.println("Processing paragraph: " + paragraphText);

            boolean containsPlaceholder = data.keySet().stream()
                    .anyMatch(key -> paragraphText.contains("{" + key + "}"));

            if (containsPlaceholder) {

                String fullText = paragraph.getText();

                for (Map.Entry<String, String> entry : data.entrySet()) {
                    String placeholder = "{" + entry.getKey() + "}";
                    if (fullText.contains(placeholder)) {
                        System.out.println("Found placeholder: " + placeholder);
                        fullText = fullText.replace(placeholder, entry.getValue());
                    }
                }

                while (paragraph.getRuns().size() > 1) {
                    paragraph.removeRun(1);
                }

                if (paragraph.getRuns().size() > 0) {
                    XWPFRun run = paragraph.getRuns().get(0);
                    run.setText(fullText, 0);
                } else {

                    XWPFRun run = paragraph.createRun();
                    run.setText(fullText, 0);
                }
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.write(outputStream);
        document.close();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.docx")
                .body(outputStream.toByteArray());
    }
}
