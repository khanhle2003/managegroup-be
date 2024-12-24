package main.main.AddData.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddDataDto {
    private String fullname;
    private String unit;
    private String country;
    private String tripPurpose;
    private String jobTitle;
    private String selfFunded;
    private String sponsor;
    private String hospital;
    private String invitationUnit;
    private String partyMember;
    private int foreignTripCount;
    private LocalDate startDate;
    private LocalDate endDate;
}
