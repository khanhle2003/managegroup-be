package main.main.thongke.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.main.thongke.repo.dataofCountryRepo;

@Service
public class dataofCountryService {
    
    @Autowired
    private dataofCountryRepo dataRepository;
    
    public List<String> getAllDistinctCountries() {
        return dataRepository.findDistinctCountries();
    }
}