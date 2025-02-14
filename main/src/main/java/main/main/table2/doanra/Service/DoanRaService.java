package main.main.table2.doanra.Service;


import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.shetRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoanRaService {
    @Autowired
    private DoanRaRepository doanRaRepository;

    public DoanRaEntity updateDoanRa(int id, DoanRaEntity updatedEntity) {
        return doanRaRepository.findById(id)
                .map(existingEntity -> {
                    existingEntity.setHoVaTen(updatedEntity.getHoVaTen());
                    existingEntity.setNgaySinh(updatedEntity.getNgaySinh());
                    existingEntity.setGioiTinh(updatedEntity.getGioiTinh());
                    existingEntity.setChucDanh(updatedEntity.getChucDanh());
                    existingEntity.setChucVu(updatedEntity.getChucVu());
                    existingEntity.setHoChieu(updatedEntity.getHoChieu());
                    existingEntity.setDonViCongTac(updatedEntity.getDonViCongTac());
                    existingEntity.setSDT(updatedEntity.getSDT());
                    existingEntity.setEmail(updatedEntity.getEmail());
                    existingEntity.setQuocTich(updatedEntity.getQuocTich());
                    existingEntity.setMucDich(updatedEntity.getMucDich());
                    existingEntity.setTuNgay(updatedEntity.getTuNgay());
                    existingEntity.setDenNgay(updatedEntity.getDenNgay());
                    existingEntity.setTuTuc(updatedEntity.getTuTuc());
                    existingEntity.setTaiTro(updatedEntity.getTaiTro());
                    existingEntity.setBenhVien(updatedEntity.getBenhVien());
                    existingEntity.setGiaTri(updatedEntity.getGiaTri());
                    existingEntity.setSoLanToi(updatedEntity.getSoLanToi());
                    existingEntity.setNgayGhiTrenTT(updatedEntity.getNgayGhiTrenTT());
                    existingEntity.setNgayPHTQTnhan(updatedEntity.getNgayPHTQTnhan());
                    existingEntity.setBGDpheDuyet(updatedEntity.getBGDpheDuyet());
                    existingEntity.setThuNgoNumber(updatedEntity.getThuNgoNumber());
                    existingEntity.setThuNgoDate(updatedEntity.getThuNgoDate());
                    existingEntity.setBaoCaoSauChuyenCongTac(updatedEntity.getBaoCaoSauChuyenCongTac());
                    existingEntity.setGhiChu(updatedEntity.getGhiChu());
                    existingEntity.setQuaTang(updatedEntity.getQuaTang());
                    return doanRaRepository.save(existingEntity);
                })
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bản ghi với id = " + id));
    }
}