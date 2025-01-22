package main.main.thongke.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitationSearchRequest {
    private List<String> invitationUnits;
    private String year;
}