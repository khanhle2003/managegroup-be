package main.main.table2.doanra.Service;


import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.shetRepo.DoanRaRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DataofCusService2 {
    @Autowired
    private static DoanRaRepo DataofCusRepo;

    public static List<DoanRaEntity> getAllTrips() {
        return DataofCusRepo.findAll();
    }
    public DoanRaEntity addDoanRa(DoanRaEntity doanRaEntity) {
        return DataofCusRepo.save(doanRaEntity);
    
}
}


