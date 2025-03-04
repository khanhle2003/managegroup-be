package main.main.AddData.entity;



import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tonghop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FullName")
    private String FullName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthDate")
    private String birth_date;
    @Column(name = "PartyBranch")
    private String partyBranch;
    @Column(name = "PartyPosition")
    private String partyPosition;
    @Column(name = "JobTitle")
    private String JobTitle;
    @Column(name = "JobName")
    private String jobName;
    @Column(name = "Unit")
    private String Unit;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "Country")
    private String Country;
    @Column(name = "InvitationUnit")
    private String InvitationUnit;
    @Column(name = "MoiDichDanh")
    private String MoiDichDanh;
    @Column(name = "TripPurpose")
    private String TripPurpose;
    @Column(name = "StartDate")
    private String StartDate;
    @Column(name = "monthBegin")//tjang bat dau
    private String monthBegon;
    @Column(name = "EndDate")
    private String EndDate;
    @Column(name = "Thoigiandichuyen")
    private String Thoigiandichuyen;
    @Column(name = "SelfFunded")
    private String SelfFunded;
    @Column(name = "Sponsor")
    private String Sponsor;
    @Column(name = "Hospital")
    private String Hospital;
    @Column(name = "giaTri")
    private String giaTri;
    @Column(name = "ForeignTripCount")
    private String ForeignTripCount;
    @Column(name = "ngayXindi")
    private String ngayXindi; 
    @Column(name = "ngayPnhanHS")
    private String ngayPnhanHS;
    @Column(name = "NotificationNumber")
    private String notificationNumber;
    @Column(name = "NotificationDate")
    private String notificationDate;
    @Column(name = "ngaychuyenHSsangP")
    private String ngaychuyenHSsangP;
    @Column(name = "Alternative")//ng tiep nhan
    private String alternative;
    @Column(name = "SoNghiPhep")
    private String SoNghiPhep;
    @Column(name = "NgayNghiPhep")
    private String NgayNghiPhep;
    @Column(name = "SubmitDay")
    private String submitDay; 
    @Column(name = "PhotoHochieu")
    private String PhotoHochieu; 
    @Column(name = "NoiDung")
    private String NoiDung; 
    @Column(name = "TenBaoCao")
    private String TenBaoCao; 
    @Column(name = "Hoan/huy")
    private String HoanHuy;
    @Column(name = "Khac")
    private String Khac;
    @Column(name = "Employee")
    private String Employee;

}
