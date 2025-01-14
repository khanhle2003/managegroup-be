package main.main.exportData.services;

import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.Repo.suadulieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class suadulieuService {
    @Autowired
    private suadulieuRepository repository;

    public DataofCusEntity updateData(int id, DataofCusEntity newData) {
        Optional<DataofCusEntity> optionalData = repository.findById(id);
        if (optionalData.isPresent()) {
            DataofCusEntity existingData = optionalData.get();
            
            existingData.setSTT(newData.getSTT());
            existingData.setFullName(newData.getFullName());
            existingData.setBirthDate(newData.getBirthDate());
            existingData.setGender(newData.getGender());
            existingData.setPartyBranch(newData.getPartyBranch());
            existingData.setPartyPosition(newData.getPartyPosition());
            existingData.setJobTitle(newData.getJobTitle());
            existingData.setJobName(newData.getJobName());
            existingData.setUnit(newData.getUnit());
            existingData.setPhoneNumber(newData.getPhoneNumber());
            existingData.setEmail(newData.getEmail());
            existingData.setCountry(newData.getCountry());
            existingData.setInvitationUnit(newData.getInvitationUnit());
            existingData.setMoiDichDanh(newData.getMoiDichDanh());
            existingData.setTripPurpose(newData.getTripPurpose());
            existingData.setStartDate(newData.getStartDate());
            existingData.setMonthBegon(newData.getMonthBegon());
            existingData.setEndDate(newData.getEndDate());
            existingData.setThoigiandichuyen(newData.getThoigiandichuyen());
            existingData.setSelfFunded(newData.getSelfFunded());
            existingData.setSponsor(newData.getSponsor());
            existingData.setHospital(newData.getHospital());
            existingData.setGiaTri(newData.getGiaTri());
            existingData.setForeignTripCount(newData.getForeignTripCount());
            existingData.setNgayXindi(newData.getNgayXindi());
            existingData.setNgayPnhanHS(newData.getNgayPnhanHS());
            existingData.setNotificationNumber(newData.getNotificationNumber());
            existingData.setNotificationDate(newData.getNotificationDate());
            existingData.setNgaychuyenHSsangP(newData.getNgaychuyenHSsangP());
            existingData.setAlternative(newData.getAlternative());
            existingData.setSoNghiPhep(newData.getSoNghiPhep());
            existingData.setNgayNghiPhep(newData.getNgayNghiPhep());
            existingData.setSubmitDay(newData.getSubmitDay());
            existingData.setPhotoHochieu(newData.getPhotoHochieu());
            existingData.setNoiDung(newData.getNoiDung());
            existingData.setTenBaoCao(newData.getTenBaoCao());
            existingData.setHoanHuy(newData.getHoanHuy());
            existingData.setKhac(newData.getKhac());
            
            // Lưu dữ liệu
            return repository.save(existingData);
        } else {
            throw new RuntimeException("Entity not found with ID: " + id);
        }
    }
}