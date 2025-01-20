package main.main.thongke.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.main.exportData.Entity.DataofCusEntity;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiCountryYearResponse {
    private List<DataofCusEntity> allData;  
    private Map<String, List<DataofCusEntity>> dataByCountry;  
    private Map<String, Long> countByCountry;  
    private Long totalCount;  
    private String year;  
}