package main.main.exportData.services;

import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.Repo.DataofCusRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DataofCusService {
    @Autowired
    private DataofCusRepo DataofCusRepo;

    public List<DataofCusEntity> getAllTrips() {
        return DataofCusRepo.findAll();
    }
}

