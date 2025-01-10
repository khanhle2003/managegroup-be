package main.main.exportData.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.streaming.SXSSFSheet;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.main.exportData.Entity.DataofCusEntity;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ExportSXSSFController {

      public ExportSXSSFController() {
        // Empty constructor
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
            headerRow.createCell(4).setCellValue("Chức vụ đảng");
            headerRow.createCell(5).setCellValue("Chức danh nghề nghiệp");
            headerRow.createCell(6).setCellValue("Chức vụ chính quyền");
            headerRow.createCell(7).setCellValue("Đơn vị công tác");
            headerRow.createCell(8).setCellValue("Số điện thoại");
            headerRow.createCell(9).setCellValue("Email");
            headerRow.createCell(10).setCellValue("Quốc gia đến");
            headerRow.createCell(11).setCellValue("Đơn vị mời");
            headerRow.createCell(12).setCellValue("Mục đích chyến đi");
            headerRow.createCell(13).setCellValue("Từ ngày");
            headerRow.createCell(14).setCellValue("Đến ngày");
            headerRow.createCell(15).setCellValue("Tự túc");
            headerRow.createCell(16).setCellValue("Tài trợ");
            headerRow.createCell(17).setCellValue("Bênh viện");
            headerRow.createCell(18).setCellValue("Số lần xin đi ra trong nước ngoài");
            headerRow.createCell(19).setCellValue("Nghị quyết đảng uỷ số");
            headerRow.createCell(20).setCellValue("Nghị quyết đảng uỷ ngày");
            headerRow.createCell(21).setCellValue("Người tiếp nhận");


            headerRow.createCell(28).setCellValue("Ngày nộp báo cáo kết quả");

            headerRow.createCell(24).setCellValue("Loại nhân viên");
            headerRow.createCell(26).setCellValue("Số ngày đã nghỉ trong năm");
            headerRow.createCell(28).setCellValue("Ngày nộp báo cáo kết quả");

    
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
                row.createCell(12).setCellValue(data.getTripPurpose());
                Cell startDateCell = row.createCell(13);
                if (data.getStartDate() != null) {
                    startDateCell.setCellValue(data.getStartDate());
                    startDateCell.setCellStyle(dateStyle);
                }
                Cell endDateCell = row.createCell(14);
                if (data.getEndDate() != null) {
                    endDateCell.setCellValue(data.getEndDate());
                    endDateCell.setCellStyle(dateStyle);
                }

                row.createCell(15).setCellValue(data.getSelfFunded());
                row.createCell(16).setCellValue(data.getSponsor());
                row.createCell(17).setCellValue(data.getHospital());
                row.createCell(18).setCellValue(data.getSubmitDay());
                row.createCell(19).setCellValue(data.getNotificationNumber());
                row.createCell(20).setCellValue(data.getNotificationDate());
                row.createCell(21).setCellValue(data.getAlternative());
                row.createCell(22).setCellValue(data.getAlternative());
                row.createCell(23).setCellValue(data.getJobName());
                row.createCell(24).setCellValue(data.getRestCount());
                row.createCell(25).setCellValue(data.getAlternative());
                row.createCell(26).setCellValue(data.getSubmitDay());

            }
    
            // Auto size các cột
            for (int i = 0; i < 27; i++) {
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
