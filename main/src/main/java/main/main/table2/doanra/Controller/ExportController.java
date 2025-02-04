package main.main.table2.doanra.Controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.streaming.SXSSFSheet;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.main.exportData.Entity.DataofCusEntity;
import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.Service.DataofCusService2;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ExportController {

    @Autowired
    private DataofCusService2 dataofCusService;

    private static final String EXPORT_DIRECTORY = "backup/"; 

    public ExportController() {
        new File(EXPORT_DIRECTORY).mkdirs();
    }

    @Scheduled(cron = "0 0 0 * * SUN")
    public void automaticWeeklyExport() {
        try {
            List<DoanRaEntity> allData = dataofCusService.getAllTrips();
            
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = EXPORT_DIRECTORY + "danh_sach_di_nuoc_ngoai_" + timestamp + ".xlsx";
            
            createExcelFile(allData, fileName);
            
            System.out.println("Đã xuất file Excel tự động: " + fileName);
        } catch (Exception e) {
            System.err.println("Lỗi khi xuất file Excel tự động: " + e.getMessage());
        }
    }

    private void createExcelFile(List<DoanRaEntity> data, String fileName) throws IOException {
        try (SXSSFWorkbook workbook = new SXSSFWorkbook(100)) {
            Sheet sheet = workbook.createSheet("Data");
            ((SXSSFSheet)sheet).trackAllColumnsForAutoSizing();
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Họ và Tên");
            headerRow.createCell(1).setCellValue("Ngày sinh");
            headerRow.createCell(2).setCellValue("Giới tính");
            headerRow.createCell(3).setCellValue("Chức danh");
            headerRow.createCell(4).setCellValue("Chức vụ");
            headerRow.createCell(5).setCellValue("Hộ chiếu");
            headerRow.createCell(6).setCellValue("Đơn vị công tác");
            headerRow.createCell(7).setCellValue("Số điện thoại");
            headerRow.createCell(8).setCellValue("Email");
            headerRow.createCell(9).setCellValue("Quốc tịch");
            headerRow.createCell(10).setCellValue("Mục đích chuyến đi");
            headerRow.createCell(11).setCellValue("Từ ngày");
            headerRow.createCell(12).setCellValue("Đến ngày");
            headerRow.createCell(13).setCellValue("Tự túc");
            headerRow.createCell(14).setCellValue("Tài trợ");
            headerRow.createCell(15).setCellValue("Bệnh viện");
            headerRow.createCell(16).setCellValue("Giá trị");
            headerRow.createCell(17).setCellValue("Số lần đã tới bệnh viện");
            headerRow.createCell(18).setCellValue("Ngày ghi trên TT");
            headerRow.createCell(19).setCellValue("Ngày PHQT nhận");
            headerRow.createCell(20).setCellValue("BGD phê duyệt");
            headerRow.createCell(21).setCellValue("Số thư ngỏ");
            headerRow.createCell(22).setCellValue("Ngày thư ngỏ");
            headerRow.createCell(23).setCellValue("Báo cáo sau chuyến công tác");
            headerRow.createCell(24).setCellValue("Ghi chú");
            headerRow.createCell(25).setCellValue("Quà tặng");

            // Fill data
            int rowNum = 1;
            for (DoanRaEntity item : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(item.getHoVaTen());
                row.createCell(1).setCellValue(item.getNgaySinh());
                row.createCell(2).setCellValue(item.getGioiTinh());
                row.createCell(3).setCellValue(item.getChucDanh());
                row.createCell(4).setCellValue(item.getChucVu());
                row.createCell(5).setCellValue(item.getHoChieu());
                row.createCell(6).setCellValue(item.getDonViCongTac());
                row.createCell(7).setCellValue(item.getSDT());
                row.createCell(8).setCellValue(item.getEmail());
                row.createCell(9).setCellValue(item.getQuocTich());
                row.createCell(10).setCellValue(item.getMucDich());
                row.createCell(11).setCellValue(item.getTuNgay());
                row.createCell(12).setCellValue(item.getDenNgay());
                row.createCell(13).setCellValue(item.getTuTuc());
                row.createCell(14).setCellValue(item.getTaiTro());
                row.createCell(15).setCellValue(item.getBenhVien());
                row.createCell(16).setCellValue(item.getGiaTri());
                row.createCell(17).setCellValue(item.getSoLanToi());
                row.createCell(18).setCellValue(item.getNgayGhiTrenTT());
                row.createCell(19).setCellValue(item.getNgayPHTQTnhan());
                row.createCell(20).setCellValue(item.getBGDpheDuyet());
                row.createCell(21).setCellValue(item.getThuNgoNumber());
                row.createCell(22).setCellValue(item.getThuNgoDate());
                row.createCell(23).setCellValue(item.getBaoCaoSauChuyenCongTac());
                row.createCell(24).setCellValue(item.getGhiChu());
                row.createCell(25).setCellValue(item.getQuaTang());
            }

            for (int i = 0; i < 26; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                workbook.write(fileOut);
            }
            workbook.dispose();
        }
    }

    @PostMapping("/export/doanvao")
    public ResponseEntity<byte[]> exportToExcel(@RequestBody List<DoanRaEntity> selectedData) throws IOException {
        try (SXSSFWorkbook workbook = new SXSSFWorkbook(100)) {
            workbook.setCompressTempFiles(true);
            Sheet sheet = workbook.createSheet("Data");
            ((SXSSFSheet)sheet).trackAllColumnsForAutoSizing();
            // Create header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Họ và Tên");
            headerRow.createCell(1).setCellValue("Ngày sinh");
            headerRow.createCell(2).setCellValue("Giới tính");
            headerRow.createCell(3).setCellValue("Chức danh");
            headerRow.createCell(4).setCellValue("Chức vụ");
            headerRow.createCell(5).setCellValue("Hộ chiếu");
            headerRow.createCell(6).setCellValue("Đơn vị công tác");
            headerRow.createCell(7).setCellValue("Số điện thoại");
            headerRow.createCell(8).setCellValue("Email");
            headerRow.createCell(9).setCellValue("Quốc tịch");
            headerRow.createCell(10).setCellValue("Mục đích chuyến đi");
            headerRow.createCell(11).setCellValue("Từ ngày");
            headerRow.createCell(12).setCellValue("Đến ngày");
            headerRow.createCell(13).setCellValue("Tự túc");
            headerRow.createCell(14).setCellValue("Tài trợ");
            headerRow.createCell(15).setCellValue("Bệnh viện");
            headerRow.createCell(16).setCellValue("Giá trị");
            headerRow.createCell(17).setCellValue("Số lần đã tới bệnh viện");
            headerRow.createCell(18).setCellValue("Ngày ghi trên TT");
            headerRow.createCell(19).setCellValue("Ngày PHQT nhận");
            headerRow.createCell(20).setCellValue("BGD phê duyệt");
            headerRow.createCell(21).setCellValue("Số thư ngỏ");
            headerRow.createCell(22).setCellValue("Ngày thư ngỏ");
            headerRow.createCell(23).setCellValue("Báo cáo sau chuyến công tác");
            headerRow.createCell(24).setCellValue("Ghi chú");
            headerRow.createCell(25).setCellValue("Quà tặng");

            // Fill data
            int rowNum = 1;
            for (DoanRaEntity data : selectedData) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(data.getHoVaTen());
                row.createCell(1).setCellValue(data.getNgaySinh());
                row.createCell(2).setCellValue(data.getGioiTinh());
                row.createCell(3).setCellValue(data.getChucDanh());
                row.createCell(4).setCellValue(data.getChucVu());
                row.createCell(5).setCellValue(data.getHoChieu());
                row.createCell(6).setCellValue(data.getDonViCongTac());
                row.createCell(7).setCellValue(data.getSDT());
                row.createCell(8).setCellValue(data.getEmail());
                row.createCell(9).setCellValue(data.getQuocTich());
                row.createCell(10).setCellValue(data.getMucDich());
                row.createCell(11).setCellValue(data.getTuNgay());
                row.createCell(12).setCellValue(data.getDenNgay());
                row.createCell(13).setCellValue(data.getTuTuc());
                row.createCell(14).setCellValue(data.getTaiTro());
                row.createCell(15).setCellValue(data.getBenhVien());
                row.createCell(16).setCellValue(data.getGiaTri());
                row.createCell(17).setCellValue(data.getSoLanToi());
                row.createCell(18).setCellValue(data.getNgayGhiTrenTT());
                row.createCell(19).setCellValue(data.getNgayPHTQTnhan());
                row.createCell(20).setCellValue(data.getBGDpheDuyet());
                row.createCell(21).setCellValue(data.getThuNgoNumber());
                row.createCell(22).setCellValue(data.getThuNgoDate());
                row.createCell(23).setCellValue(data.getBaoCaoSauChuyenCongTac());
                row.createCell(24).setCellValue(data.getGhiChu());
                row.createCell(25).setCellValue(data.getQuaTang());
            }

            // Auto size columns
            for (int i = 0; i < 26; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            workbook.dispose();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.attachment().filename("danh_sach_di_nuoc_ngoai.xlsx").build());

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
        }
    }
}
