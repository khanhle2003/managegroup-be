package main.main.jwtauth.service;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.jsonwebtoken.io.IOException;
import jakarta.transaction.Transactional;
import main.main.jwtauth.repository.listDoanRepo;

@Service
@Transactional
public class ExcelImportService1 {
    @Autowired
    private listDoanRepo dataofCusRepo;

    public void importFromExcel(MultipartFile file) throws IOException, java.io.IOException {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())){
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rows = sheet.iterator();
            rows.next();



            // while (rows.hasNext()){
            //     Row row = rows.next();

            //     listDoan listdoan1 = new listDoan();
            //     listdoan1.setSTT(getCellValue(row.getCell(0)));
            //     listdoan1.setFullName(getCellValue(row.getCell(1)));
            //     listdoan1.setBirthDate(getCellValue(row.getCell(2)));
            //     listdoan1.setGender(getCellValue(row.getCell(3)));
            //     listdoan1.setPartyBranch(getCellValue(row.getCell(4)));
            //     listdoan1.setPartyPosition(getCellValue(row.getCell(5)));
            //     listdoan1.setJobTitle(getCellValue(row.getCell(6)));
            //     listdoan1.setJobName(getCellValue(row.getCell(7)));
            //     listdoan1.setUnit(getCellValue(row.getCell(8)));
            //     listdoan1.setPhoneNumber(getCellValue(row.getCell(9)));
            //     listdoan1.setEmail(getCellValue(row.getCell(10)));
            //     listdoan1.setCountry(getCellValue(row.getCell(11)));
            //     listdoan1.setInvitationUnit(getCellValue(row.getCell(12)));
            //     listdoan1.setMoiDichDanh(getCellValue(row.getCell(13)));
            //     listdoan1.setTripPurpose(getCellValue(row.getCell(14)));
            //     listdoan1.setStartDate(getCellValue(row.getCell(15)));
            //     listdoan1.setMonthBegon(getCellValue(row.getCell(16)));
            //     listdoan1.setEndDate(getCellValue(row.getCell(17)));
            //     listdoan1.setThoigiandichuyen(getCellValue(row.getCell(18)));
            //     listdoan1.setSelfFunded(getCellValue(row.getCell(19)));
            //     listdoan1.setSponsor(getCellValue(row.getCell(20)));
            //     listdoan1.setHospital(getCellValue(row.getCell(21)));
            //     listdoan1.setGiaTri(getCellValue(row.getCell(22)));
            //     listdoan1.setForeignTripCount(getCellValue(row.getCell(23)));
            //     listdoan1.setNgayXindi(getCellValue(row.getCell(24)));
            //     listdoan1.setNgayPnhanHS(getCellValue(row.getCell(25)));
            //     listdoan1.setNotificationNumber(getCellValue(row.getCell(26)));
            //     listdoan1.setNotificationDate(getCellValue(row.getCell(27)));
            //     listdoan1.setNgaychuyenHSsangP(getCellValue(row.getCell(28)));
            //     listdoan1.setAlternative(getCellValue(row.getCell(29)));
            //     listdoan1.setSoNghiPhep(getCellValue(row.getCell(30)));
            //     listdoan1.setNgayNghiPhep(getCellValue(row.getCell(31)));
            //     listdoan1.setSubmitDay(getCellValue(row.getCell(32)));
            //     listdoan1.setPhotoHochieu(getCellValue(row.getCell(33)));
            //     listdoan1.setNoiDung(getCellValue(row.getCell(34)));
            //     listdoan1.setTenBaoCao(getCellValue(row.getCell(35)));
            //     listdoan1.setHoanHuy(getCellValue(row.getCell(36)));
            //     listdoan1.setKhac(getCellValue(row.getCell(37)));

            //     dataofCusRepo.save(listdoan1);

            // }
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