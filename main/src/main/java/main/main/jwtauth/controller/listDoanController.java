package main.main.jwtauth.controller;


import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.service.listDoanservice;
import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.Service.DataofCusService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class listDoanController {
    @Autowired
    private listDoanservice ListDoanservice;

    @GetMapping("/doanra")
    @ResponseBody
    public List<listDoan> showTrips(Model model) {
        List<listDoan> listDoans = ListDoanservice.getAllTrips();
        return listDoans;
    }

    @GetMapping("/auth/qldoan/columns")
    @ResponseBody
    public List<Map<String, String>> showTripsColumns() {
        List<listDoan> listDoans = ListDoanservice.getAllTrips();

        // Tạo danh sách chứa các Map với 2 cột notificationDate và ngayNghiPhep
        List<Map<String, String>> result = new ArrayList<>();

        for (listDoan doan : listDoans) {
            Map<String, String> data = new HashMap<>();
            data.put("notificationDate", doan.getNotificationDate());
            data.put("ngayNghiPhep", doan.getNgayNghiPhep());
            result.add(data);
        }
        return result;
    }

//    @GetMapping("/auth/qldoan/columns2")
//    @ResponseBody
//    public List<Map<String, String>> showTripsColumns2() {
//        List<DoanRaEntity> listDoans2;
//        listDoans2 = DataofCusService2.getAllTrips();
//
//        // Tạo danh sách chứa các Map với 2 cột notificationDate và ngayNghiPhep
//        List<Map<String, String>> result2 = new ArrayList<>();
//
//        for (DoanRaEntity doan2 : listDoans2) {
//            Map<String, String> data2 = new HashMap<>();
//            data2.put("notificationDate", doan2.getTuNgay());
//            data2.put("ngayNghiPhep", doan2.getDenNgay());
//            result2.add(data2);
//        }
//        return result2;
//    }



    @GetMapping("/auth/qldoan/average-by-year")
    public double getAverageDaysByYear(@RequestParam int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<listDoan> trips = ListDoanservice.getAllTrips()
                .stream()
                .filter(trip -> {
                    try {
                        LocalDate notificationDate = LocalDate.parse(trip.getNotificationDate(), formatter);
                        return notificationDate.getYear() == year;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (trips.isEmpty()) {
            return 0;
        }

        double totalDays = trips.stream()
                .mapToDouble(trip -> {
                    try {
                        LocalDate notificationDate = LocalDate.parse(trip.getNotificationDate(), formatter);
                        LocalDate ngayNghiPhep = LocalDate.parse(trip.getNgayNghiPhep(), formatter);
                        long daysBetween = ChronoUnit.DAYS.between(notificationDate, ngayNghiPhep);
                        return Math.max(daysBetween, 1); // Luôn trả về ít nhất 1 ngày
                    } catch (Exception e) {
                        return 1; // Nếu lỗi format ngày, giả định 1 ngày
                    }
                })
                .average()
                .orElse(0);

        return totalDays;
    }

//    @GetMapping("/auth/qldoan/average-by-year2")
//    public double getAverageDaysByYear2(@RequestParam int year) {
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        List<DoanRaEntity> trips2 = DataofCusService2.getAllTrips()
//                .stream()
//                .filter(trip2 -> {
//                    try {
//                        LocalDate TuNgay = LocalDate.parse(trip2.getTuNgay(), formatter2);
//                        return TuNgay.getYear() == year;
//                    } catch (Exception e) {
//                        return false;
//                    }
//                })
//                .collect(Collectors.toList());
//
//        if (trips2.isEmpty()) {
//            return 0;
//        }
//
//        double totalDays = trips2.stream()
//                .mapToDouble(trip2 -> {
//                    try {
//                        LocalDate TuNgay = LocalDate.parse(trip2.getTuNgay(), formatter2);
//                        LocalDate DenNgay = LocalDate.parse(trip2.getDenNgay(), formatter2);
//                        long daysBetween = ChronoUnit.DAYS.between(TuNgay, DenNgay);
//                        return Math.max(daysBetween, 1); // Luôn trả về ít nhất 1 ngày
//                    } catch (Exception e) {
//                        return 1; // Nếu lỗi format ngày, giả định 1 ngày
//                    }
//                })
//                .average()
//                .orElse(0);
//
//        return totalDays;
//    }

}