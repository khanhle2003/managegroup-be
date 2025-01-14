package main.main.exportData.Controller;


import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suadl")
public class suadulieuController {
    @Autowired
    private suadulieuService service;

    @PutMapping("/{id}")
    public ResponseEntity<DataofCusEntity> updateData(@PathVariable int id, @RequestBody DataofCusEntity newData) {
        try {
            DataofCusEntity updatedData = service.updateData(id, newData);
            return ResponseEntity.ok(updatedData);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
