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

        data.setDauthoigian(request.getDauthoigian());
        data.setFullName(request.getFullName());
        data.setBirthDate(request.getBirthDate());
        data.setGender(request.getGender());
        data.setPartyBranch(request.getPartyBranch());
        data.setPartyPosition(request.getPartyPosition());
        data.setLanhanvien(request.getLanhanvien());
        data.setJobTitle(request.getJobTitle());
        data.setJobName(request.getJobName());
        data.setUnit(request.getUnit());
        data.setPhoneNumber(request.getPhoneNumber());
        data.setCodcmoihaykhong(request.getCodcmoihaykhong());
        data.setStartDate(request.getStartDate());
        data.setEndDate(request.getEndDate());
        data.setBaogomthoigiandichuyenchua(request.getBaogomthoigiandichuyenchua());
        data.setTripPurpose(request.getTripPurpose());
        data.setNdcuthe(request.getNdcuthe());
        data.setSelfFunded(request.getSelfFunded());
        data.setHospital(request.getHospital());
        data.setForeignTripCount(request.getForeignTripCount());
        data.setBangiaocv(request.getBangiaocv());
        data.setEmail(request.getEmail());
        data.setMoiDichDanh(request.getMoiDichDanh());
        data.setInvitationUnit(request.getInvitationUnit());
        data.setTentcmoi(request.getTentcmoi());
        data.setNdhoinghi(request.getNdhoinghi());
        data.setSongaynghiphep(request.getSongaynghiphep());
        data.setNdviecrieng(request.getNdviecrieng());
        data.setTcngoaiBvtaitro(request.getTcngoaiBvtaitro());
        data.setDangtaithumoi(request.getDangtaithumoi());
        data.setThongtindinhkem(request.getThongtindinhkem());
        data.setCCCD(request.getCCCD());
        data.setCountry(request.getCountry());
        data.setTenBaoCao(request.getTenBaoCao());
        data.setOral(request.getOral());
        data.setQddinuocngoai(request.getQddinuocngoai());
        data.setNotificationNumber(request.getNotificationNumber());
        data.setNotificationDate(request.getNotificationDate());
        data.setTinhtrangchuyendi(request.getTinhtrangchuyendi());
        data.setEmailLD(request.getEmailLD());
        data.setNgaydithucte(request.getNgaydithucte());
        data.setNgaydenthucte(request.getNgaydenthucte());
        data.setBaocaotomtat(request.getBaocaotomtat());
        data.setTiepxuccoquan(request.getTiepxuccoquan());
        data.setViechaphanhbaovebimatnn(request.getViechaphanhbaovebimatnn());
        data.setVdelienquandenchinhtrinoibo(request.getVdelienquandenchinhtrinoibo());
        data.setHdngoaikehoach(request.getHdngoaikehoach());
        data.setCertificate(request.getCertificate());
        data.setNdynghiaapdungvatrienkhaibenhvien(request.getNdynghiaapdungvatrienkhaibenhvien());
        data.setDexuatkiennghi(request.getDexuatkiennghi());
        data.setTtquyetdinh(request.getTtquyetdinh());
        data.setLydohoan(request.getLydohoan());
        data.setNdchuyendibihoan(request.getNdchuyendibihoan());
        data.setMayte(request.getMayte());
        data.setEditURL(request.getEditURL());
        data.setDocURL(request.getDocURL());
        data.setIncrement(request.getIncrement());
        data.setPdfURL(request.getPdfURL());
        data.setGiaTri(request.getGiaTri());
        data.setNgayXindi(request.getNgayXindi());
        data.setNgayPnhanHS(request.getNgayPnhanHS());
        data.setNgaychuyenHSsangP(request.getNgaychuyenHSsangP());
        data.setAlternative(request.getAlternative());
        data.setSoNghiPhep(request.getSoNghiPhep());
        data.setNgayNghiPhep(request.getNgayNghiPhep());
        data.setSubmitDay(request.getSubmitDay());
        data.setPhotoHochieu(request.getPhotoHochieu());
        data.setNoiDung(request.getNoiDung());
        data.setHoanHuy(request.getHoanHuy());
        data.setKhac(request.getKhac());
        data.setPartyMember(request.getPartyMember());
        data.setEmployee(request.getEmployee());
        data.setRestCount(request.getRestCount());
        data.setMonthBegon(request.getMonthBegon());
        data.setThoigiandichuyen(request.getThoigiandichuyen());
        data.setSponsor(request.getSponsor());

        // data.setPartyMember(request.getPartyMember());
        // data.setEmployee(request.getEmployee()); 
        // data.setRestCount(request.getRestCount()); 
        return (Data) dataRepository.save(data);
    }
}
