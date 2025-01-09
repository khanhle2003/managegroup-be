package main.main.jwtauth.service;

import jakarta.transaction.Transactional;
import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.repository.listDoanRepo;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ExcelImportService {

    @Autowired
    private listDoanRepo listdoanRepo;

    public void importFromExcel(MultipartFile file) throws IOException{
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())){
            Sheet sheet = workbook.getSheetAt(8);

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            List<listDoan> listDoans = new ArrayList<>();

            while (rows.hasNext()){
                Row row = rows.next();

                listDoan listdoan = new listDoan();
                listdoan.setFullName(getCellValue(row.getCell(1)));
                listdoan.setBirthDate(getCellValue(row.getCell(2)));
                listdoan.setGender(getCellValue(row.getCell(3)));
                listdoan.setPartyBranch(getCellValue(row.getCell(4)));
                listdoan.setJobTitle(getCellValue(row.getCell(6)));
                listdoan.setUnit(getCellValue(row.getCell(8)));
                listdoan.setPartyPosition(getCellValue(row.getCell(5)));
                listdoan.setPhoneNumber(getCellValue(row.getCell(9)));
                listdoan.setEmail(getCellValue(row.getCell(10)));
                listdoan.setJobName(getCellValue(row.getCell(7)));
                listdoan.setInvitationUnit(getCellValue(row.getCell(12)));
                listdoan.setCountry(getCellValue(row.getCell(11)));
//                listdoan.setTripPurpose(getCellValue(row.getCell(14)));
                listdoan.setStartDate(parseDate(getCellValue(row.getCell(15))));
                listdoan.setEndDate(parseDate(getCellValue(row.getCell(17))));
                listdoan.setSelfFunded(getCellValue(row.getCell(19)));
                listdoan.setSponsor(getCellValue(row.getCell(20)));
                listdoan.setHospital(getCellValue(row.getCell(21)));
                listdoan.setForeignTripCount(getCellValue(row.getCell(23)));
                listdoan.setNotificationNumber(getCellValue(row.getCell(26)));
                listdoan.setNotificationDate(getCellValue(row.getCell(27)));
                listdoan.setSubmitDay(getCellValue(row.getCell(32)));
                listdoan.setAlternative(getCellValue(row.getCell(29)));

                listdoanRepo.save(listdoan);

            }
        }
    }

    private String getCellValue(Cell cell) {
        if (cell == null){
            return "";
        }
        switch (cell.getCellType()){
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getLocalDateTimeCellValue().toString();
                }
                return String.valueOf(cell.getNumericCellValue());
            default:
                return "";
        }
    }

    private Date parseDate(String dateStr) {
        try {
            LocalDate localDate = LocalDate.parse(dateStr);
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            return null;
        }
    }

}
