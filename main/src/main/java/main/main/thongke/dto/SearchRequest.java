package main.main.thongke.dto;

import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
    private List<String> countries;
    private String year;
}
