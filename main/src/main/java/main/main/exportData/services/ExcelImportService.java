package main.main.exportData.services;

import io.jsonwebtoken.io.IOException;
import jakarta.transaction.Transactional;
import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.Repo.DataofCusRepo;
import main.main.jwtauth.repository.listDoanRepo;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    private DataofCusRepo dataofCusRepo;

    public void importFromExcel(MultipartFile file) throws IOException, java.io.IOException {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())){
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rows = sheet.iterator();
            rows.next();



            while (rows.hasNext()){
                Row row = rows.next();

                DataofCusEntity listdoan = new DataofCusEntity();
                listdoan.setSTT(getCellValue(row.getCell(0)));
                listdoan.setFullName(getCellValue(row.getCell(1)));
                listdoan.setBirthDate(getCellValue(row.getCell(2)));
                listdoan.setGender(getCellValue(row.getCell(3)));
                listdoan.setPartyBranch(getCellValue(row.getCell(4)));
                listdoan.setPartyPosition(getCellValue(row.getCell(5)));
                listdoan.setJobTitle(getCellValue(row.getCell(6)));
                listdoan.setJobName(getCellValue(row.getCell(7)));
                listdoan.setUnit(getCellValue(row.getCell(8)));
                listdoan.setPhoneNumber(getCellValue(row.getCell(9)));
                listdoan.setEmail(getCellValue(row.getCell(10)));
                listdoan.setCountry(getCellValue(row.getCell(11)));
                listdoan.setInvitationUnit(getCellValue(row.getCell(12)));
                listdoan.setMoiDichDanh(getCellValue(row.getCell(13)));
                listdoan.setTripPurpose(getCellValue(row.getCell(14)));
                listdoan.setStartDate(getCellValue(row.getCell(15)));
                listdoan.setMonthBegon(getCellValue(row.getCell(16)));
                listdoan.setEndDate(getCellValue(row.getCell(17)));
                listdoan.setThoigiandichuyen(getCellValue(row.getCell(18)));
                listdoan.setSelfFunded(getCellValue(row.getCell(19)));
                listdoan.setSponsor(getCellValue(row.getCell(20)));
                listdoan.setHospital(getCellValue(row.getCell(21)));
                listdoan.setGiaTri(getCellValue(row.getCell(22)));
                listdoan.setForeignTripCount(getCellValue(row.getCell(23)));
                listdoan.setNgayXindi(getCellValue(row.getCell(24)));
                listdoan.setNgayPnhanHS(getCellValue(row.getCell(25)));
                listdoan.setNotificationNumber(getCellValue(row.getCell(26)));
                listdoan.setNotificationDate(getCellValue(row.getCell(27)));
                listdoan.setNgaychuyenHSsangP(getCellValue(row.getCell(28)));
                listdoan.setAlternative(getCellValue(row.getCell(29)));
                listdoan.setSoNghiPhep(getCellValue(row.getCell(30)));
                listdoan.setNgayNghiPhep(getCellValue(row.getCell(31)));
                listdoan.setSubmitDay(getCellValue(row.getCell(32)));
                listdoan.setPhotoHochieu(getCellValue(row.getCell(33)));
                listdoan.setNoiDung(getCellValue(row.getCell(34)));
                listdoan.setTenBaoCao(getCellValue(row.getCell(35)));
                listdoan.setHoanHuy(getCellValue(row.getCell(36)));
                listdoan.setKhac(getCellValue(row.getCell(37)));

                dataofCusRepo.save(listdoan);

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
}