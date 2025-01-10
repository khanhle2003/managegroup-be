package main.main.AddData.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String foreignTripCount;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate notificationDate;
    private String notificationNumber;
    private String email;
    private String gender;
    private String phoneNumber;
    private String position;
    private String partyBranch;
    private String partyPosition;
    private String employee;
    private String jobName;
    private String restCount;
    private String alternative;
    private String submitDay;
    private LocalDate birthDate;
    private LocalDate birth_date; // Giữ nguyên tên biến
    private String monthBegin; // Giữ nguyên tên biến
    private String Thoigiandichuyen; // Giữ nguyên tên biến
    private String giaTri; // Giữ nguyên tên biến
    private LocalDate ngayXindi; // Giữ nguyên tên biến
    private LocalDate ngayPnhanHS; // Giữ nguyên tên biến
    private LocalDate ngaychuyenHSsangP; // Giữ nguyên tên biến
    private String SoNghiPhep; // Giữ nguyên tên biến
    private LocalDate NgayNghiPhep; // Giữ nguyên tên biến
    private LocalDate PhotoHochieu; // Giữ nguyên tên biến
    private String NoiDung; // Giữ nguyên tên biến
    private String TenBaoCao; // Giữ nguyên tên biến
    private String HoanHuy; // Giữ nguyên tên biến
    private String Khac;
    private String MoiDichDanh;

}
