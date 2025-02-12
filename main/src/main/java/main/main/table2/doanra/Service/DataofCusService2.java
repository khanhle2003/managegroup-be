package main.main.table2.doanra.Service;

import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.shetRepo.DoanRaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataofCusService2 {

    @Autowired
    private DoanRaRepo doanraRepo;

    public List<DoanRaEntity> getAllTrips() {
        return doanraRepo.findAll();
    }

    public DoanRaEntity addDoanRa(DoanRaEntity doanRaEntity) {
        return doanraRepo.save(doanRaEntity);
    }
    public void deleteData(long id) {
        if (!doanraRepo.existsById(id)) {
            throw new RuntimeException("Data not found");
        }
        doanraRepo.deleteById(id);
    }
}
