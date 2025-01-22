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
public class InvitationUnitResponse {
    private List<DataofCusEntity> allData;  // Tất cả dữ liệu
    private Map<String, List<DataofCusEntity>> dataByUnit;  // Dữ liệu phân theo đơn vị mời
    private Map<String, Long> countByUnit;  // Số lượng theo từng đơn vị mời
    private Long totalCount;  // Tổng số bản ghi
    private String year;  // Năm tìm kiếm
}
