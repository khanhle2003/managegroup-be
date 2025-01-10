package main.main.AddData.service2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.main.AddData.dto.request.AddDataDto;
import main.main.AddData.entity.Data;
import main.main.AddData.repo.DataRepo;

@Service
public class DataAddService {

    @Autowired
    private DataRepo dataRepository;

    public List<Data> getAllData() {
        return dataRepository.findAll();
    }

    public Data addData(AddDataDto request) {
        Data data = new Data();

        data.setFullName(request.getFullname());
        data.setBirth_date(request.getBirthDate()); 
        data.setGender(request.getGender());
        data.setPartyBranch(request.getPartyBranch());
        data.setPartyPosition(request.getPartyPosition());
        data.setJobTitle(request.getJobTitle());
        data.setJobName(request.getJobName());
        data.setUnit(request.getUnit());
        data.setPhoneNumber(request.getPhoneNumber());
        data.setEmail(request.getEmail());
        data.setCountry(request.getCountry());
        data.setInvitationUnit(request.getInvitationUnit());
        data.setInvitationUnit(request.getMoiDichDanh());
        data.setTripPurpose(request.getTripPurpose());
        data.setStartDate(request.getStartDate());
        data.setMonthBegon(request.getMonthBegin());
        data.setEndDate(request.getEndDate());
        data.setThoigiandichuyen(request.getThoigiandichuyen());
        data.setSelfFunded(request.getSelfFunded());
        data.setSponsor(request.getSponsor());
        data.setHospital(request.getHospital());
        data.setGiaTri(request.getGiaTri());
        data.setForeignTripCount(request.getForeignTripCount());
        data.setNgayXindi(request.getNgayXindi()); 
        data.setNgayPnhanHS(request.getNgayPnhanHS());
        data.setNotificationNumber(request.getNotificationNumber());
        data.setNotificationDate(request.getNotificationDate());
        data.setNgaychuyenHSsangP(request.getNgaychuyenHSsangP());
        data.setAlternative(request.getAlternative()); 
        data.setSoNghiPhep(request.getSoNghiPhep());
        data.setNgayNghiPhep(request.getNgayNghiPhep());
        data.setSubmitDay(request.getSubmitDay()); 
        data.setPhotoHochieu(request.getPhotoHochieu()); 
        data.setNoiDung(request.getNoiDung()); 
        data.setTenBaoCao(request.getTenBaoCao()); 
        data.setHoanHuy(request.getHoanHuy());
        data.setKhac(request.getKhac());
        data.setKhac(request.getEmployee());

        // data.setPartyMember(request.getPartyMember());
        // data.setEmployee(request.getEmployee()); 
        // data.setRestCount(request.getRestCount()); 
        return (Data) dataRepository.save(data);
    }
}
