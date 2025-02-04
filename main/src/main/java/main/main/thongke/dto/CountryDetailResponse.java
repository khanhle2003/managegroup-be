package main.main.thongke.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.main.table2.doanra.Entity.DoanRaEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDetailResponse {
   private List<DoanRaEntity> data;  // Chi tiết dữ liệu
   private Map<String, Long> countByCountry;  // Số lượng theo từng quốc gia
   private Long totalCount;  // Tổng số bản ghi
   private String year;  // Năm tìm kiếm
}