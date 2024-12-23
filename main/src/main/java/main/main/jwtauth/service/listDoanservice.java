package main.main.jwtauth.service;

import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.repository.listDoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class listDoanservice {
    @Autowired
    private listDoanRepo listDoanRepo;

    public List<listDoan> getAllTrips() {
        return listDoanRepo.findAll();
    }
}
