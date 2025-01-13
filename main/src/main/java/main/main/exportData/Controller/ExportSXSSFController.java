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
