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
    @Column(name = "dauThoiGian")
    private String dauthoigian;
    @Column(name = "FullName")
    private String FullName;
    @Column(name = "birthDate")
    private String birthDate;
    @Column(name = "gender")
    private String gender;
    @Column(name = "PartyBranch")
    private String partyBranch;
    @Column(name = "PartyPosition")
    private String partyPosition;
    @Column(name = "lanhanvien")
    private String lanhanvien;
    @Column(name = "JobTitle")
    private String JobTitle;
    @Column(name = "JobName")
    private String jobName;
    @Column(name = "Unit")
    private String Unit;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "codcmoihaykhong")
    private String codcmoihaykhong;
    @Column(name = "StartDate")
    private String StartDate;
    @Column(name = "EndDate")
    private String EndDate;
    @Column(name = "baogomthoigiandichuyenchua")
    private String baogomthoigiandichuyenchua;
    @Column(name = "TripPurpose") // muc dich chuyen di
    private String TripPurpose;
    @Column(name = "ndcuthe")
    private String ndcuthe;
    @Column(name = "SelfFunded") // tự túc
    private String SelfFunded;
    @Column(name = "Hospital") // bệnh viện
    private String Hospital;
    @Column(name = "ForeignTripCount") // so lan xin di nc ngoai
    private String ForeignTripCount;
    @Column(name = "bangiaocv")
    private String bangiaocv;
    @Column(name = "email")
    private String email;
    @Column(name = "MoiDichDanh")
    private String MoiDichDanh;
    @Column(name = "InvitationUnit") // đơn vị mời
    private String InvitationUnit;
    @Column(name = "tentcmoi") // tên tổ chức, cá nhân mời
    private String tentcmoi;
    @Column(name = "ndhoinghi") // nd cụ thể hội nghị
    private String ndhoinghi;
    @Column(name = "songaynghiphep")
    private String songaynghiphep;
    @Column(name = "ndviecrieng") // nd cụ thể việc riêng
    private String ndviecrieng;
    @Column(name = "tcngoaiBvtaitro") // tổ chức, cá nhân ngoài bv tài trợ
    private String tcngoaiBvtaitro;
    @Column(name = "dangtaithumoi")
    private String dangtaithumoi;
    @Column(name = "Thongtindinhkem")
    private String Thongtindinhkem;
    @Column(name = "CCCD")
    private String CCCD;
    @Column(name = "Country")
    private String Country;
    @Column(name = "TenBaoCao")
    private String TenBaoCao;
    @Column(name = "oral") // đăng tải chứng nhận/xác nhận báo cáo viên
    private String oral;
    @Column(name = "qddinuocngoai") // đã có quyet định đi nc ngoài chưa
    private String qddinuocngoai;
    @Column(name = "NotificationNumber")
    private String notificationNumber;
    @Column(name = "NotificationDate")
    private String notificationDate;
    @Column(name = "tinhtrangchuyendi")
    private String tinhtrangchuyendi;
    @Column(name = "emailLD") // email lãnh đạo
    private String emailLD;
    @Column(name = "ngaydithucte")
    private String ngaydithucte;
    @Column(name = "ngaydenthucte")
    private String ngaydenthucte;
    @Column(name = "baocaotomtat")
    private String baocaotomtat;
    @Column(name = "tiepxuccoquan")
    private String tiepxuccoquan;
    @Column(name = "viechaphanhquydinnhbaovebimatnn") // Việc chấp hành quy định bảo vệ bí mật Nhà nước
    private String viechaphanhbaovebimatnn;
    @Column(name = "vdelienquandenchinhtrinoibo") // Những vấn đề khác liên quan đến chính trị nội bộ
    private String vdelienquandenchinhtrinoibo;
    @Column(name = "hdngoaikehoach")
    private String hdngoaikehoach;
    @Column(name = "Certificate") // đăng tải bằng cấp chứng chỉ, chứng nhận
    private String Certificate;
    @Column(name = "ndynghiaapdungvatrienkhaibenhvien")
    // Những nội dung có ý nghĩa thiết thực có thể áp dụng và triển khai đối với
    // Bệnh viện và đơn vị
    private String ndynghiaapdungvatrienkhaibenhvien;
    @Column(name = "dexuatkiennghi")
    private String dexuatkiennghi;
    @Column(name = "ttquyetdinh")
    private String ttquyetdinh;
    @Column(name = "lydohoan")
    private String lydohoan;
    @Column(name = "ndchuyendibihoan")
    private String ndchuyendibihoan;
    @Column(name = "mayte")
    private String mayte;
    @Column(name = "editURL")
    private String editURL;
    @Column(name = "docURL")
    private String docURL;
    @Column(name = "increment")
    private String increment;
    @Column(name = "pdfURL")
    private String pdfURL;

    @Column(name = "giaTri")
    private String giaTri;
    @Column(name = "ngayXindi")
    private String ngayXindi;
    @Column(name = "ngayPnhanHS")
    private String ngayPnhanHS;
    @Column(name = "ngaychuyenHSsangP")
    private String ngaychuyenHSsangP;
    @Column(name = "Alternative") // ng tiep nhan
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
    @Column(name = "Hoan/huy")
    private String HoanHuy;
    @Column(name = "Khac")
    private String Khac;
    @Column(name = "partyMember")
    private String partyMember;
    @Column(name = "employee")
    private String employee;
    @Column(name = "RestCount")
    private String restCount;
    @Column(name = "monthBegin") // thang bat dau
    private String monthBegon;
    @Column(name = "Thoigiandichuyen")
    private String Thoigiandichuyen;
    @Column(name = "Sponsor") // nhà tài trợ
    private String Sponsor;

}
