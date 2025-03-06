package main.main.jwtauth.service;

import io.jsonwebtoken.io.IOException;
import jakarta.transaction.Transactional;
import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.repository.listDoanRepo;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;

@Service
@Transactional
public class importExcelNotDoanVienService {

    @Autowired
    private listDoanRepo listDoanRepo;

    public void importFromExcel(MultipartFile file) throws IOException, java.io.IOException {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row row = rows.next();

                listDoan listdoanNull = new listDoan();
                listdoanNull.setDauthoigian(getCellValue(row.getCell(0)));
                listdoanNull.setFullName(getCellValue(row.getCell(1)));
                listdoanNull.setBirthDate(getCellValue(row.getCell(2)));
                listdoanNull.setGender(getCellValue(row.getCell(3)));
                listdoanNull.setDangVien("KHÔNG");
                listdoanNull.setPartyBranch("KHÔNG");
                listdoanNull.setPartyPosition("KHÔNG");
                listdoanNull.setLanhanvien(getCellValue(row.getCell(4)));
                listdoanNull.setJobTitle(getCellValue(row.getCell(5)));
                listdoanNull.setJobName(getCellValue(row.getCell(6)));
                listdoanNull.setUnit(getCellValue(row.getCell(7)));
                listdoanNull.setPhoneNumber(getCellValue(row.getCell(8)));
                listdoanNull.setCountry(getCellValue(row.getCell(9)));
                listdoanNull.setCodcmoihaykhong(getCellValue(row.getCell(10)));
                listdoanNull.setStartDate(getCellValue(row.getCell(11)));
                listdoanNull.setEndDate(getCellValue(row.getCell(12)));
                listdoanNull.setBaogomthoigiandichuyenchua(getCellValue(row.getCell(13)));
                listdoanNull.setTripPurpose(getCellValue(row.getCell(14)));
                listdoanNull.setNdcuthe(getCellValue(row.getCell(15)));
                listdoanNull.setSelfFunded(getCellValue(row.getCell(16)));
                listdoanNull.setHospital(getCellValue(row.getCell(17)));
                listdoanNull.setForeignTripCount(getCellValue(row.getCell(18)));
                listdoanNull.setBangiaocv(getCellValue(row.getCell(19)));
                listdoanNull.setEmail(getCellValue(row.getCell(20)));
                listdoanNull.setMoiDichDanh(getCellValue(row.getCell(21)));
                listdoanNull.setInvitationUnit(getCellValue(row.getCell(22)));
                listdoanNull.setTentcmoi(getCellValue(row.getCell(23)));
                listdoanNull.setNdhoinghi(getCellValue(row.getCell(24)));
                listdoanNull.setSongaynghiphep(getCellValue(row.getCell(25)));
                listdoanNull.setNdviecrieng(getCellValue(row.getCell(26)));
                listdoanNull.setTcngoaiBvtaitro(getCellValue(row.getCell(27)));
                listdoanNull.setDangtaithumoi(getCellValue(row.getCell(28)));
                listdoanNull.setThongtindinhkem(getCellValue(row.getCell(29)));
                listdoanNull.setCCCD(getCellValue(row.getCell(30)));
                listdoanNull.setTenBaoCao(getCellValue(row.getCell(31)));
                listdoanNull.setOral(getCellValue(row.getCell(32)));
                listdoanNull.setQddinuocngoai(getCellValue(row.getCell(33)));
                listdoanNull.setNotificationNumber(getCellValue(row.getCell(34)));
                listdoanNull.setNotificationDate(getCellValue(row.getCell(35)));
                listdoanNull.setTinhtrangchuyendi(getCellValue(row.getCell(36)));
                listdoanNull.setEmailLD(getCellValue(row.getCell(37)));
                listdoanNull.setNgaydithucte(getCellValue(row.getCell(38)));
                listdoanNull.setNgaydenthucte(getCellValue(row.getCell(39)));
                listdoanNull.setBaocaotomtat(getCellValue(row.getCell(40)));
                listdoanNull.setTiepxuccoquan(getCellValue(row.getCell(41)));
                listdoanNull.setViechaphanhbaovebimatnn(getCellValue(row.getCell(42)));
                listdoanNull.setVdelienquandenchinhtrinoibo(getCellValue(row.getCell(43)));
                listdoanNull.setHdngoaikehoach(getCellValue(row.getCell(44)));
                listdoanNull.setCertificate(getCellValue(row.getCell(45)));
                listdoanNull.setNdynghiaapdungvatrienkhaibenhvien(getCellValue(row.getCell(46)));
                listdoanNull.setDexuatkiennghi(getCellValue(row.getCell(47)));
                listdoanNull.setTtquyetdinh(getCellValue(row.getCell(48)));
                listdoanNull.setLydohoan(getCellValue(row.getCell(49)));
                listdoanNull.setNdchuyendibihoan(getCellValue(row.getCell(50)));
                listdoanNull.setMayte(getCellValue(row.getCell(51)));
                listdoanNull.setEditURL(getCellValue(row.getCell(52)));
                listdoanNull.setDocURL(getCellValue(row.getCell(53)));
                listdoanNull.setIncrement(getCellValue(row.getCell(54)));
                listdoanNull.setPdfURL(getCellValue(row.getCell(55)));

                listDoanRepo.save(listdoanNull);

            }
        }
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
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
