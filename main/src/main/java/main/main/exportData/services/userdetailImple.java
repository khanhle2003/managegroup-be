package main.main.exportData.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.Repo.userdetailRepo;
@Service
public class userdetailImple implements userdetailService{
@Autowired
    private userdetailRepo dataRepository;

      @Override
    public DataofCusEntity getDataById(Long id) {
        return dataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu với ID: " + id));
    }
}
