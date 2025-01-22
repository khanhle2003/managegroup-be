package main.main.thongke.service;


import main.main.exportData.Entity.DataofCusEntity;
import main.main.thongke.dto.InvitationUnitResponse;
import main.main.thongke.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class thongkedvmService {
    
    @Autowired
    private thongkedvmRepo thongkeRepo;
    
    public InvitationUnitResponse getDataByInvitationUnitsAndYear(List<String> invitationUnits, String year) {
        List<DataofCusEntity> data = thongkeRepo.findByInvitationUnitsAndYear(invitationUnits, year);
        Long totalCount = thongkeRepo.countByInvitationUnitsAndYear(invitationUnits, year);
        
        // Phân loại dữ liệu theo từng đơn vị mời
        Map<String, List<DataofCusEntity>> dataByUnit = data.stream()
            .collect(Collectors.groupingBy(DataofCusEntity::getInvitationUnit));
            
        // Đếm số lượng theo từng đơn vị mời
        Map<String, Long> countByUnit = dataByUnit.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> (long) entry.getValue().size()
            ));
            
        return new InvitationUnitResponse(data, dataByUnit, countByUnit, totalCount, year);
    }
}