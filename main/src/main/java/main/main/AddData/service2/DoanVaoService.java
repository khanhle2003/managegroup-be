package main.main.AddData.service2;


import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.AddData.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("doanRaTable2Service")  // Thêm tên cụ thể cho service
public class DoanVaoService {
    
    @Autowired
    private DoanVaoRepository doanRaRepository;
    
    @Transactional
    public DoanRaEntity addDoanRa(DoanRaEntity doanRa) {
        return doanRaRepository.save(doanRa);
    }
}