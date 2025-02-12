package main.main.table2.doanra.Controller;

import io.jsonwebtoken.io.IOException;
import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.Service.DataofCusService2;
import main.main.table2.doanra.Service.DoanRaImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController

public class DoanRaController {

    @Autowired
    private DataofCusService2 dataofCusService2;
    @GetMapping("/doanvao")
    @ResponseBody
    public List<DoanRaEntity> showTrips(Model model) {
        List<DoanRaEntity> doanras = dataofCusService2.getAllTrips();
        return doanras;
    }
    @Autowired
    private DoanRaImport doanRaImport;

    @PostMapping("/import2")
    public ResponseEntity<String> importExcel(@RequestParam("file") MultipartFile file) {
        try {
            doanRaImport.importFromExcel(file);
            return ResponseEntity.ok("Import thành công");
        } catch (IOException | java.io.IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi import: " + e.getMessage());
        }
    }
    
     @PostMapping("/adddv")
    public ResponseEntity<DoanRaEntity> addDoanRa(@RequestBody DoanRaEntity doanRaEntity) {
        // Kiểm tra giá trị của doanRaEntity
        System.out.println(doanRaEntity); // In ra để kiểm tra
        try {
            DoanRaEntity savedEntity = dataofCusService2.addDoanRa(doanRaEntity);
            return ResponseEntity.ok(savedEntity);
        } catch (Exception e) {
            // Log lỗi và trả về phản hồi lỗi
            e.printStackTrace(); // In ra console để kiểm tra
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Hoặc có thể trả về thông điệp lỗi
        }
    }

        @GetMapping("/auth/qldoan/columns2")
    @ResponseBody
    public List<Map<String, String>> showTripsColumns2() {
        List<DoanRaEntity> listDoans2;
        listDoans2 = dataofCusService2.getAllTrips();

        // Tạo danh sách chứa các Map với 2 cột notificationDate và ngayNghiPhep
        List<Map<String, String>> result2 = new ArrayList<>();

        for (DoanRaEntity doan2 : listDoans2) {
            Map<String, String> data2 = new HashMap<>();
            data2.put("notificationDate", doan2.getTuNgay());
            data2.put("ngayNghiPhep", doan2.getDenNgay());
            result2.add(data2);
        }
        return result2;
    }

        @GetMapping("/auth/qldoan/average-by-year2")
    public double getAverageDaysByYear2(@RequestParam int year) {
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<DoanRaEntity> trips2 = dataofCusService2.getAllTrips()
                .stream()
                .filter(trip2 -> {
                    try {
                        LocalDate TuNgay = LocalDate.parse(trip2.getTuNgay(), formatter2);
                        return TuNgay.getYear() == year;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (trips2.isEmpty()) {
            return 0;
        }

        double totalDays = trips2.stream()
                .mapToDouble(trip2 -> {
                    try {
                        LocalDate TuNgay = LocalDate.parse(trip2.getTuNgay(), formatter2);
                        LocalDate DenNgay = LocalDate.parse(trip2.getDenNgay(), formatter2);
                        long daysBetween = ChronoUnit.DAYS.between(TuNgay, DenNgay);
                        return Math.max(daysBetween, 1); // Luôn trả về ít nhất 1 ngày
                    } catch (Exception e) {
                        return 1; // Nếu lỗi format ngày, giả định 1 ngày
                    }
                })
                .average()
                .orElse(0);

        return totalDays;
    }

}
