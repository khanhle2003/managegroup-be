package main.main.table2.doanra.Controller;

import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.Service.userdetailService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qldoan/detail")
public class detailController {
    @Autowired
    private userdetailService2 dataService2;

    @GetMapping("/{id}")
    public ResponseEntity<DoanRaEntity> getDataById(@PathVariable Long id) {
        DoanRaEntity data1 = dataService2.getDataById(id);
        return ResponseEntity.ok(data1);
    }
}
