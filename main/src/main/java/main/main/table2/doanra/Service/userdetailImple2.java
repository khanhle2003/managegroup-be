package main.main.table2.doanra.Service;

import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.Repo.userdetailRepo;
import main.main.exportData.services.userdetailService;
import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.shetRepo.userdetailRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userdetailImple2 implements userdetailService2 {
    @Autowired
    private userdetailRepo2 dataRepository2;

    @Override
    public DoanRaEntity getDataById(Long id) {
        return dataRepository2.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu với ID: " + id));
    }
}
