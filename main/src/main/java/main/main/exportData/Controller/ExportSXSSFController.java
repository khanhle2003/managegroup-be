package main.main.exportData.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import main.main.exportData.Entity.DataofCusEntity;

@RequestMapping("/api")
public class ExportSXSSFController {
    @PostMapping("/export")
public ResponseEntity<byte[]> exportToExcel(@RequestBody List<DataofCusEntity> selectedData) throws IOException {
 try(SXSSFWorkbook workbook = new SXSSFWorkbook(100)) {
    Sheet sheet  = workbook.createSheet("Data output");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Họ và Tên");
        headerRow.createCell(1).setCellValue("Đơn vị");
        headerRow.createCell(2).setCellValue("Quốc gia");
        headerRow.createCell(3).setCellValue("Mục đích chuyến đi");
        headerRow.createCell(4).setCellValue("Chức vụ");
        headerRow.createCell(5).setCellValue("Tự túc");
        headerRow.createCell(6).setCellValue("Nhà tài trợ");
        headerRow.createCell(7).setCellValue("Bệnh viện");
        headerRow.createCell(8).setCellValue("HD/BC");
        headerRow.createCell(9).setCellValue("Đơn vị mời");
        headerRow.createCell(10).setCellValue("Đoàn");
        headerRow.createCell(11).setCellValue("Đảng viên");
        headerRow.createCell(12).setCellValue("Số chuyến đi nước ngoài");
        headerRow.createCell(13).setCellValue("Số thông báo");
        headerRow.createCell(14).setCellValue("Ngày thông báo");
        headerRow.createCell(15).setCellValue("Thành phố");
        headerRow.createCell(16).setCellValue("Ngày bắt đầu");
        headerRow.createCell(17).setCellValue("Ngày kết thúc");
         CellStyle dateStyle  = workbook.createCellStyle();
        dateStyle.setDataFormat(workbook.createDataFormat().getFormat("dd/MM/yy"));





        int rowNum = 1;
        for (DataofCusEntity data : selectedData) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.getFullName());
            row.createCell(1).setCellValue(data.getUnit());
            row.createCell(2).setCellValue(data.getCountry());
            row.createCell(3).setCellValue(data.getTripPurpose());
            row.createCell(4).setCellValue(data.getJobTitle());
            row.createCell(5).setCellValue(data.getSelfFunded());
            row.createCell(6).setCellValue(data.getSponsor());
            row.createCell(7).setCellValue(data.getHospital());
            row.createCell(8).setCellValue(data.getHdBc());
            row.createCell(9).setCellValue(data.getInvitationUnit());
            row.createCell(10).setCellValue(data.getDoan());
            row.createCell(11).setCellValue(data.getPartyMember());
            row.createCell(12).setCellValue(data.getForeignTripCount());
            row.createCell(13).setCellValue(data.getNotificationNumber());
            row.createCell(14).setCellValue(data.getNotificationDate());
            row.createCell(15).setCellValue(data.getCity());


                 Cell startDateCell = row.createCell(16);
            if (data.getStartDate() != null) {
                startDateCell.setCellValue(data.getStartDate());
                startDateCell.setCellStyle(dateStyle);
            }

            Cell endDateCell = row.createCell(17);
            if (data.getEndDate() != null) {
                endDateCell.setCellValue(data.getEndDate());
                endDateCell.setCellStyle(dateStyle);
            }
 }
 for(int i = 0; i <18; i++){
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
