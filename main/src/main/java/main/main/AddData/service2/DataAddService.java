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

    public List<Data> getAllData(){
        return dataRepository.findAll();
    }
    public Data addData(AddDataDto request){
        Data data = new Data();

        data.setFullName(request.getFullname());
        data.setUnit(request.getUnit());
        data.setCountry(request.getCountry());
        data.setTripPurpose(request.getTripPurpose());
        data.setJobTitle(request.getJobTitle());
        data.setSelfFunded(request.getSelfFunded());
        data.setSponsor(request.getSponsor());
        data.setHospital(request.getHospital());
        data.setInvitationUnit(request.getInvitationUnit());
        data.setPartyMember(request.getPartyMember());
        data.setForeignTripCount(request.getForeignTripCount());
        data.setStartDate(request.getStartDate());
        data.setEndDate(request.getEndDate());
        data.setNotificationDate(request.getNotificationDate());
        data.setNotificationNumber(request.getNotificationNumber());
        data.setGender(request.getGender());
        data.setEmail(request.getEmail());
        data.setPhoneNumber(request.getPhoneNumber());
        data.setPartyBranch(request.getPartyBranch());
        data.setParty_position(request.getParty_position());
        data.setJobName(request.getJobName());
        data.setRestCount(request.getRestCount());
        data.setAlternative(request.getAlternative());
        data.setSubmitDay(request.getSubmitDay());
        data.setEmployee(request.getEmployee());

        return (Data) dataRepository.save(data);
    }
}
