package main.main.thongke.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.thongke.dto.CountryDetailResponse;
import main.main.thongke.repo.*;
@Service
public class thongkeService2 {
 @Autowired
    private thongkerepo2 thongkerepo2;
   
   public CountryDetailResponse getDataByYearAndCountries(String year, List<String> countries) {
       List<DoanRaEntity> data = thongkerepo2.findByYearAndCountries(year, countries);
       

       List<Object[]> countResults = thongkerepo2.countByYearAndCountries(year, countries);
       Map<String, Long> countByCountry = countResults.stream()
           .collect(Collectors.toMap(
               result -> (String) result[0], 
               result -> ((Number) result[1]).longValue()
           ));
       
       Long totalCount = countByCountry.values().stream()
           .mapToLong(Long::longValue)
           .sum();
       
       return new CountryDetailResponse(data, countByCountry, totalCount, year);
   }
}
