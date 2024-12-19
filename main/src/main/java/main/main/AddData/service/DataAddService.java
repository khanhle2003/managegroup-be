package main.main.AddData.service;

import main.main.AddData.dto.request.AddDataDto;
import main.main.AddData.entity.Data;
import main.main.AddData.repo.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        return (Data) dataRepository.save(data);
    }
}
