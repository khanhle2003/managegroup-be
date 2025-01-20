package main.main.thongke.service;

import main.main.exportData.Entity.DataofCusEntity;
import main.main.thongke.dto.*;
import main.main.thongke.repo.thongkeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class thongkeService {
    
    @Autowired
    private thongkeRepo thongkeRepo;
    
    public MultiCountryYearResponse getDataByCountriesAndYear(List<String> countries, String year) {
        List<DataofCusEntity> data = thongkeRepo.findByCountriesAndYear(countries, year);
        Long totalCount = thongkeRepo.countByCountriesAndYear(countries, year);
        
        // Phân loại dữ liệu theo từng quốc gia
        Map<String, List<DataofCusEntity>> dataByCountry = data.stream()
            .collect(Collectors.groupingBy(DataofCusEntity::getCountry));
            
        // Đếm số lượng theo từng quốc gia
        Map<String, Long> countByCountry = dataByCountry.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> (long) entry.getValue().size()
            ));
            
        return new MultiCountryYearResponse(data, dataByCountry, countByCountry, totalCount, year);
    }
}