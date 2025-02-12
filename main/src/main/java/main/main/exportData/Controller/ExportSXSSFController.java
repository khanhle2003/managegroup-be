package main.main.exportData.Controller;

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
import main.main.exportData.services.DataofCusService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ExportSXSSFController {


 @Autowired
    private DataofCusService dataofCusService;

    private static final String EXPORT_DIRECTORY = "backup/"; 




      public ExportSXSSFController() {
        new File(EXPORT_DIRECTORY).mkdirs();
    }
    // @Scheduled(cron = "*/5 * * * * *")
   @Scheduled(cron = "0 0 0 * * SUN")
    public void automaticWeeklyExport() {
        try {
            List<DataofCusEntity> allData = dataofCusService.getAllTrips();
            

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = EXPORT_DIRECTORY + "danh_sach_di_nuoc_ngoai_" + timestamp + ".xlsx";
            

            createExcelFile(allData, fileName);
            
            System.out.println("Đã xuất file Excel tự động: " + fileName);
        } catch (Exception e) {
            System.err.println("Lỗi khi xuất file Excel tự động: " + e.getMessage());
        }
    }

private void createExcelFile(List<DataofCusEntity> data, String fileName) throws IOException {
    try (SXSSFWorkbook workbook = new SXSSFWorkbook(100)) {
        Sheet sheet = workbook.createSheet("Data");
        ((SXSSFSheet)sheet).trackAllColumnsForAutoSizing();
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Họ và Tên");
        headerRow.createCell(1).setCellValue("Ngày sinh");
        headerRow.createCell(2).setCellValue("Giới tính");
        headerRow.createCell(3).setCellValue("Đảng viên");
        headerRow.createCell(4).setCellValue("Chức vụ Đảng");
        headerRow.createCell(5).setCellValue("Chức danh nghề nghiệp");
        headerRow.createCell(6).setCellValue("Chức vụ chính quyền");
        headerRow.createCell(7).setCellValue("Đơn vị công tác");
        headerRow.createCell(8).setCellValue("Số điện thoại");
        headerRow.createCell(9).setCellValue("Email");
        headerRow.createCell(10).setCellValue("Quốc gia đền");
        headerRow.createCell(11).setCellValue("Đơn vị mời");
        headerRow.createCell(12).setCellValue("Mời đích danh");
        headerRow.createCell(13).setCellValue("Mục đích chuyến đi");
        headerRow.createCell(14).setCellValue("Ngày bắt đầu");
        headerRow.createCell(15).setCellValue("Tháng bắt đầu");
        headerRow.createCell(16).setCellValue("Ngày kết thúc");
        headerRow.createCell(17).setCellValue("Thời gian đi chuyến");
        headerRow.createCell(18).setCellValue("Tự túc");
        headerRow.createCell(19).setCellValue("Nhà tài trợ");
        headerRow.createCell(20).setCellValue("Bệnh viện");
        headerRow.createCell(21).setCellValue("Giá trị");
        headerRow.createCell(22).setCellValue("Số chuyến đi nước ngoài");
        headerRow.createCell(23).setCellValue("Ngày xin đi");
        headerRow.createCell(24).setCellValue("Ngày nhận hồ sơ");
        headerRow.createCell(25).setCellValue("Số thông báo");
        headerRow.createCell(26).setCellValue("Ngày thông báo");
        headerRow.createCell(27).setCellValue("Ngày chuyển hồ sơ sang phòng");
        headerRow.createCell(28).setCellValue("Người tiếp nhận");
        headerRow.createCell(29).setCellValue("Số nghỉ phép");
        headerRow.createCell(30).setCellValue("Ngày nghỉ phép");
        headerRow.createCell(31).setCellValue("Ngày nộp báo cáo");
        headerRow.createCell(32).setCellValue("Hộ chiếu");
        headerRow.createCell(33).setCellValue("Nội dung");
        headerRow.createCell(34).setCellValue("Tên báo cáo");
        headerRow.createCell(35).setCellValue("Hoãn/hủy");
        headerRow.createCell(36).setCellValue("Khác");


        // Fill data
        int rowNum = 1;
        for (DataofCusEntity item : data) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(item.getFullName());
            row.createCell(1).setCellValue(item.getBirthDate());
            row.createCell(2).setCellValue(item.getGender());
            row.createCell(3).setCellValue(item.getPartyBranch());
            row.createCell(4).setCellValue(item.getPartyPosition());
            row.createCell(5).setCellValue(item.getJobTitle());
            row.createCell(6).setCellValue(item.getJobName());
            row.createCell(7).setCellValue(item.getUnit());
            row.createCell(8).setCellValue(item.getPhoneNumber());
            row.createCell(9).setCellValue(item.getEmail());
            row.createCell(10).setCellValue(item.getCountry());
            row.createCell(11).setCellValue(item.getInvitationUnit());
            row.createCell(12).setCellValue(item.getMoiDichDanh());
            row.createCell(13).setCellValue(item.getTripPurpose());
            row.createCell(14).setCellValue(item.getStartDate());
            row.createCell(15).setCellValue(item.getMonthBegon());
            row.createCell(16).setCellValue(item.getEndDate());
            row.createCell(17).setCellValue(item.getThoigiandichuyen());
            row.createCell(18).setCellValue(item.getSelfFunded());
            row.createCell(19).setCellValue(item.getSponsor());
            row.createCell(20).setCellValue(item.getHospital());
            row.createCell(21).setCellValue(item.getGiaTri());
            row.createCell(22).setCellValue(item.getForeignTripCount());
            row.createCell(23).setCellValue(item.getNgayXindi());
            row.createCell(24).setCellValue(item.getNgayPnhanHS());
            row.createCell(25).setCellValue(item.getNotificationNumber());
            row.createCell(26).setCellValue(item.getNotificationDate());
            row.createCell(27).setCellValue(item.getNgaychuyenHSsangP());
            row.createCell(28).setCellValue(item.getAlternative());
            row.createCell(29).setCellValue(item.getSoNghiPhep());
            row.createCell(30).setCellValue(item.getNgayNghiPhep());
            row.createCell(31).setCellValue(item.getSubmitDay());
            row.createCell(32).setCellValue(item.getPhotoHochieu());
            row.createCell(33).setCellValue(item.getNoiDung());
            row.createCell(34).setCellValue(item.getTenBaoCao());
            row.createCell(35).setCellValue(item.getHoanHuy());
            row.createCell(36).setCellValue(item.getKhac());
        }

      
        for (int i = 0; i < 37; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        }
        workbook.dispose();
    }
}


















    @PostMapping("/export")
    public ResponseEntity<byte[]> exportToExcel(@RequestBody List<DataofCusEntity> selectedData) throws IOException {
        try (SXSSFWorkbook workbook = new SXSSFWorkbook(100)) {
             workbook.setCompressTempFiles(true);
            Sheet sheet = workbook.createSheet("Data");
          ((SXSSFSheet)sheet).trackAllColumnsForAutoSizing();
            // Tạo header
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Họ và Tên");
            headerRow.createCell(1).setCellValue("Ngày sinh");
            headerRow.createCell(2).setCellValue("Giới tính");
            headerRow.createCell(3).setCellValue("Đảng viên");
            headerRow.createCell(4).setCellValue("Chức vụ Đảng");
            headerRow.createCell(5).setCellValue("Chức danh nghề nghiệp");
            headerRow.createCell(6).setCellValue("Chức vụ chính quyền");
            headerRow.createCell(7).setCellValue("Đơn vị công tác");
            headerRow.createCell(8).setCellValue("Số điện thoại");
            headerRow.createCell(9).setCellValue("Email");
            headerRow.createCell(10).setCellValue("Quốc gia đến");
            headerRow.createCell(11).setCellValue("Đơn vị mời");
            headerRow.createCell(12).setCellValue("Mời đích danh");
            headerRow.createCell(13).setCellValue("Mục đích chuyến đi");
            headerRow.createCell(14).setCellValue("Ngày bắt đầu");
            headerRow.createCell(15).setCellValue("Tháng bắt đầu");
            headerRow.createCell(16).setCellValue("Ngày kết thúc");
            headerRow.createCell(17).setCellValue("Thời gian đi chuyến");
            headerRow.createCell(18).setCellValue("Tự túc");
            headerRow.createCell(19).setCellValue("Nhà tài trợ");
            headerRow.createCell(20).setCellValue("Bệnh viện");
            headerRow.createCell(21).setCellValue("Giá trị");
            headerRow.createCell(22).setCellValue("Số chuyến đi nước ngoài");
            headerRow.createCell(23).setCellValue("Ngày xin đi");
            headerRow.createCell(24).setCellValue("Ngày nhận hồ sơ");
            headerRow.createCell(25).setCellValue("Số thông báo");
            headerRow.createCell(26).setCellValue("Ngày thông báo");
            headerRow.createCell(27).setCellValue("Ngày chuyển hồ sơ sang phòng");
            headerRow.createCell(28).setCellValue("Người tiếp nhận");
            headerRow.createCell(29).setCellValue("Số nghỉ phép");
            headerRow.createCell(30).setCellValue("Ngày nghỉ phép");
            headerRow.createCell(31).setCellValue("Ngày nộp báo cáo");
            headerRow.createCell(32).setCellValue("Hộ chiếu");
            headerRow.createCell(33).setCellValue("Nội dung");
            headerRow.createCell(34).setCellValue("Tên báo cáo");
            headerRow.createCell(35).setCellValue("Hoãn/hủy");
            headerRow.createCell(36).setCellValue("Khác");
    
            // Style cho ngày tháng
            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(workbook.createDataFormat().getFormat("dd/MM/yyyy"));
    
            // Điền dữ liệu
            int rowNum = 1;
            for (DataofCusEntity data : selectedData) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(data.getFullName());
                row.createCell(1).setCellValue(data.getBirthDate());
                row.createCell(2).setCellValue(data.getGender());
                row.createCell(3).setCellValue(data.getPartyBranch());
                row.createCell(4).setCellValue(data.getPartyPosition());
                row.createCell(5).setCellValue(data.getJobTitle());
                row.createCell(6).setCellValue(data.getJobName());
                row.createCell(7).setCellValue(data.getUnit());
                row.createCell(8).setCellValue(data.getPhoneNumber());
                row.createCell(9).setCellValue(data.getEmail());
                row.createCell(10).setCellValue(data.getCountry());
                row.createCell(11).setCellValue(data.getInvitationUnit());
                row.createCell(12).setCellValue(data.getMoiDichDanh());
                row.createCell(13).setCellValue(data.getTripPurpose());
                row.createCell(14).setCellValue(data.getStartDate());
                row.createCell(15).setCellValue(data.getMonthBegon());
                row.createCell(16).setCellValue(data.getEndDate());
                row.createCell(17).setCellValue(data.getThoigiandichuyen());
                row.createCell(18).setCellValue(data.getSelfFunded());
                row.createCell(19).setCellValue(data.getSponsor());
                row.createCell(20).setCellValue(data.getHospital());
                row.createCell(21).setCellValue(data.getGiaTri());
                row.createCell(22).setCellValue(data.getForeignTripCount());
                row.createCell(23).setCellValue(data.getNgayXindi());
                row.createCell(24).setCellValue(data.getNgayPnhanHS());
                row.createCell(25).setCellValue(data.getNotificationNumber());
                row.createCell(26).setCellValue(data.getNotificationDate());
                row.createCell(27).setCellValue(data.getNgaychuyenHSsangP());
                row.createCell(28).setCellValue(data.getAlternative());
                row.createCell(29).setCellValue(data.getSoNghiPhep());
                row.createCell(30).setCellValue(data.getNgayNghiPhep());
                row.createCell(31).setCellValue(data.getSubmitDay());
                row.createCell(32).setCellValue(data.getPhotoHochieu());
                row.createCell(33).setCellValue(data.getNoiDung());
                row.createCell(34).setCellValue(data.getTenBaoCao());
                row.createCell(35).setCellValue(data.getHoanHuy());
                row.createCell(36).setCellValue(data.getKhac());
            }
    
            // Auto size các cột
            for (int i = 0; i < 37; i++) {
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
