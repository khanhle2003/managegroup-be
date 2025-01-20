


package main.main.exportData.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.main.exportData.Entity.DataofCusEntity;
import main.main.exportData.services.userdetailService;
@RestController
@RequestMapping("/auth/qldoan")

public class userdetailController {
@Autowired
    private userdetailService dataService;

    @GetMapping("/{id}")
    public ResponseEntity<DataofCusEntity> getDataById(@PathVariable Long id) {
        DataofCusEntity data = dataService.getDataById(id);
        return ResponseEntity.ok(data);
    }
}
