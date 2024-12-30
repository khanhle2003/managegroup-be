package main.main.exportData.Controller;


import main.main.exportData.services.BackupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/backup")
public class BackupController {
    private final BackupService backupService;

    public BackupController(BackupService backupService) {
        this.backupService = backupService;
    }

    @PostMapping("/{type}")
    public ResponseEntity<String> triggerBackup(@PathVariable String type) {
        if (!type.equals("weekly") && !type.equals("monthly")) {
            return ResponseEntity.badRequest()
                    .body("Invalid backup type. Use 'weekly' or 'monthly'");
        }

        boolean success = backupService.performManualBackup(type);

        if (success) {
            return ResponseEntity.ok("Backup completed successfully");
        } else {
            return ResponseEntity.internalServerError()
                    .body("Backup failed. Check logs for details");
        }
    }
}
