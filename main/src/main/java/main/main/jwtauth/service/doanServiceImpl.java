package main.main.jwtauth.service;

import main.main.jwtauth.model.listDoan;
import main.main.jwtauth.repository.listDoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import main.main.jwtauth.util.importUtils;

import java.io.IOException;
import java.util.List;

@Service
public class doanServiceImpl implements doanService{
    @Autowired
    listDoanRepo doanRepo;
    @Override
    public void save(MultipartFile file) throws IOException {
        try{
            List<listDoan> doanList = importUtils.excelToDoanList(file.getInputStream());
        }catch (IOException ex){
            throw new RuntimeException("Excel data is failed to store: " + ex.getMessage());
        }
    }
    @Override
    public List<listDoan> findAll(){
        return doanRepo.findAll();
    }
}
