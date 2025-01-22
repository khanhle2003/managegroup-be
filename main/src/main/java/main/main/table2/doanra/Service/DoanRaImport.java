package main.main.table2.doanra.Service;

import io.jsonwebtoken.io.IOException;
import jakarta.transaction.Transactional;
import main.main.exportData.Entity.DataofCusEntity;
import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.shetRepo.DoanRaRepo;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;

@Service
@Transactional
public class DoanRaImport {
    @Autowired
    private DoanRaRepo doanRaRepo;

    public void importFromExcel(MultipartFile file) throws IOException, java.io.IOException {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())){
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rows = sheet.iterator();
            rows.next();



            while (rows.hasNext()){
                Row row = rows.next();

                DoanRaEntity listdoan2 = new DoanRaEntity();
                listdoan2.setHoVaTen(getCellValue(row.getCell(0)));
                listdoan2.setNgaySinh(getCellValue(row.getCell(1)));
                listdoan2.setGioiTinh(getCellValue(row.getCell(2)));
                listdoan2.setChucDanh(getCellValue(row.getCell(3)));
                listdoan2.setChucVu(getCellValue(row.getCell(4)));
                listdoan2.setHoChieu(getCellValue(row.getCell(5)));
                listdoan2.setDonViCongTac(getCellValue(row.getCell(6)));
                listdoan2.setSDT(getCellValue(row.getCell(7)));
                listdoan2.setEmail(getCellValue((row.getCell(8))));
                listdoan2.setQuocTich(getCellValue(row.getCell(9)));
                listdoan2.setMucDich(getCellValue(row.getCell(10)));
                listdoan2.setTuNgay(getCellValue(row.getCell(11)));
                listdoan2.setDenNgay(getCellValue(row.getCell(12)));
                listdoan2.setTuTuc(getCellValue(row.getCell(13)));
                listdoan2.setTaiTro(getCellValue(row.getCell(14)));
                listdoan2.setBenhVien(getCellValue(row.getCell(15)));
                listdoan2.setGiaTri(getCellValue(row.getCell(16)));
                listdoan2.setSoLanToi(getCellValue(row.getCell(17)));
                listdoan2.setNgayGhiTrenTT(getCellValue(row.getCell(18)));
                listdoan2.setNgayPHTQTnhan(getCellValue(row.getCell(19)));
                listdoan2.setBGDpheDuyet(getCellValue(row.getCell(20)));
                listdoan2.setThuNgoNumber(getCellValue(row.getCell(21)));
                listdoan2.setThuNgoDate(getCellValue(row.getCell(22)));
                listdoan2.setBaoCaoSauChuyenCongTac(getCellValue(row.getCell(23)));
                listdoan2.setGhiChu(getCellValue(row.getCell(24)));
                listdoan2.setQuaTang(getCellValue(row.getCell(25)));

                doanRaRepo.save(listdoan2);

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
