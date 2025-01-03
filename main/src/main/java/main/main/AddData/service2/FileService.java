package main.main.AddData.service2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import main.main.AddData.entity.Data;

@Service
public class FileService {
    private static final String BASE_PATH = "D:/data/";

    private String generateFileName(Data entity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("%d_%s_%s_%s.txt",
                entity.getId(),
                entity.getFullName().replaceAll("\\s+", "_"),
                entity.getStartDate().format(formatter),
                entity.getEndDate().format(formatter));
    }

    public void saveToNotepad(Data data) {
        try {
            String fileName = generateFileName(data);
            String fullPath = BASE_PATH + fileName;
            

            File directory = new File(BASE_PATH);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            FileWriter fileWriter = new FileWriter(fullPath);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("ID: " + data.getId() + "\n");
            writer.write("Full Name: " + data.getFullName() + "\n");
            writer.write("Unit: " + data.getUnit() + "\n");
            writer.write("Country: " + data.getCountry() + "\n");
            writer.write("Trip Purpose: " + data.getTripPurpose() + "\n");
            writer.write("Job Title: " + data.getJobTitle() + "\n");
            writer.write("Self Funded: " + data.getSelfFunded() + "\n");
            writer.write("Sponsor: " + data.getSponsor() + "\n");
            writer.write("Hospital: " + data.getHospital() + "\n");
            writer.write("Invitation Unit: " + data.getInvitationUnit() + "\n");
            writer.write("Party Member: " + data.getPartyMember() + "\n");
            writer.write("Foreign Trip Count: " + data.getForeignTripCount() + "\n");
            writer.write("Notification Number: " + data.getNotificationNumber() + "\n");
            writer.write("Notification Date: " + data.getNotificationDate() + "\n");
            writer.write("Start Date: " + data.getStartDate() + "\n");
            writer.write("End Date: " + data.getEndDate() + "\n");
            
            writer.close();
            
        } catch (IOException e) {
            throw new RuntimeException("Không thể ghi file: " + e.getMessage());
        }
    }
}