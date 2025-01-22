package main.main.table2.doanra.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "data9")
public class DoanRaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "HoVaTen")
    private String HoVaTen;
    @Column(name = "NgaySinh")
    private String NgaySinh;
    @Column(name = "GioiTinh")
    private String GioiTinh;
    @Column(name = "ChucDanh")
    private String ChucDanh;
    @Column(name = "ChucVu")
    private String ChucVu;
    @Column(name = "HoChieu")
    private String HoChieu;
    @Column(name = "DonViCongTac")
    private String DonViCongTac;
    @Column(name = "SDT")
    private String SDT;
    @Column(name = "Email")
    private String Email;
    @Column(name = "QuocTich")
    private String QuocTich;
    @Column(name = "MucDichChuyenTham")
    private String MucDich;
    @Column(name = "TuNgay")
    private String TuNgay;
    @Column(name = "DenNgay")
    private String DenNgay;
    @Column(name = "TuTuc")
    private String TuTuc;
    @Column(name = "TaiTro")
    private String TaiTro;
    @Column(name = "BenhVien")
    private String BenhVien;
    @Column(name = "GiaTri")
    private String GiaTri;
    @Column(name = "SoLanDaToiBenhVien")
    private String SoLanToi;
    @Column(name = "NgayGhiTrenTT")
    private String NgayGhiTrenTT;
    @Column(name = "NgayPHTQTnhan")
    private String NgayPHTQTnhan;
    @Column(name = "BGDpheDuyet")
    private String BGDpheDuyet;
    @Column(name = "ThuNgoNumber")
    private String ThuNgoNumber;
    @Column(name = "ThuNgoDate")
    private String ThuNgoDate;
    @Column(name = "BaoCaoSauChuyenCongTac")
    private String BaoCaoSauChuyenCongTac;
    @Column(name = "GhiChu")
    private String GhiChu;
    @Column(name = "QuaTang")
    private String QuaTang;

}
