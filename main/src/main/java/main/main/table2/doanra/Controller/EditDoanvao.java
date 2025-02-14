package main.main.table2.doanra.Controller;

import main.main.table2.doanra.Entity.DoanRaEntity;
import main.main.table2.doanra.Service.DoanRaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doanvao/edit")
public class EditDoanvao {
    @Autowired
    private DoanRaService doanRaService;

    @PutMapping("/{id}")
    public ResponseEntity<DoanRaEntity> updateDoanRa(@PathVariable int id, @RequestBody DoanRaEntity doanRaEntity) {
        try {
            DoanRaEntity updatedEntity = doanRaService.updateDoanRa(id, doanRaEntity);
            return ResponseEntity.ok(updatedEntity);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}