package main.main.exportData.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

@Service
public class BackupService {
    private final String dbUsername;
    private final String dbPassword;
    private final String dbName;
    private final String backupDir;

    private static final Logger logger = LoggerFactory.getLogger(BackupService.class);

    public BackupService(String dbUsername, String dbPassword, String dbName, String backupDir) {
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.dbName = dbName;
        this.backupDir = backupDir;
        createBackupDirectory();
    }

    private void createBackupDirectory() {
        File dir = new File(backupDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    // Backup hàng tuần vào 00:00 Chủ nhật
    @Scheduled(cron = "0 0 0 * * 0")
    public void performWeeklyBackup() {
        performBackup("weekly");
    }

    // Backup hàng tháng vào 00:00 ngày 1
    @Scheduled(cron = "0 0 0 1 * *")
    public void performMonthlyBackup() {
        performBackup("monthly");
    }

    private boolean performBackup(String backupType) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
        String backupFileName = String.format("%s/data_table_%s_backup_%s.sql", backupDir, backupType, timestamp);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "mysqldump",
                    "-u", dbUsername,
                    "-p" + dbPassword,
                    dbName,
                    "data",  // Chỉ backup bảng data
                    "--add-drop-table",
                    "--complete-insert",
                    "--extended-insert=FALSE",
                    "--result-file=" + backupFileName
            );

            processBuilder.environment().put("LANG", "en_US.UTF-8");

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                compressFile(backupFileName);
                new File(backupFileName).delete();
                logger.info("Data table {} backup completed: {}.gz", backupType, backupFileName);
                cleanupOldBackups(backupType);
                return true;
            } else {
                logger.error("Data table backup failed with exit code: {}", exitCode);
                return false;
            }

        } catch (Exception e) {
            logger.error("Error during data table backup: {}", e.getMessage());
            return false;
        }
    }

    private void compressFile(String sourceFile) throws Exception {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             GZIPOutputStream gzos = new GZIPOutputStream(
                     new FileOutputStream(sourceFile + ".gz"))) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gzos.write(buffer, 0, len);
            }
        }
    }

    private void cleanupOldBackups(String backupType) {
        File dir = new File(backupDir);
        File[] files = dir.listFiles((d, name) ->
                name.startsWith("data_table_" + backupType) && name.endsWith(".gz"));

        if (files == null || files.length == 0) return;

        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        int keepCount = backupType.equals("weekly") ? 4 : 12;

        for (int i = keepCount; i < files.length; i++) {
            if (files[i].delete()) {
                logger.info("Deleted old backup: {}", files[i].getName());
            }
        }
    }

    public boolean performManualBackup(String type) {
        if (!type.equals("weekly") && !type.equals("monthly")) {
            logger.error("Invalid backup type: {}", type);
            return false;
        }
        return performBackup(type);
    }
}
