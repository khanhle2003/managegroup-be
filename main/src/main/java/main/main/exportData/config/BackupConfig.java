package main.main.exportData.config;


import main.main.exportData.services.BackupService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class BackupConfig {
    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${backup.directory}")
    private String backupDir;

    @Bean
    public BackupService backupService() {
        return new BackupService(dbUsername, dbPassword, extractDbName(dbUrl), backupDir);
    }

    private String extractDbName(String url) {
        // Lấy tên database từ URL
        return url.substring(url.lastIndexOf("/") + 1).split("\\?")[0];
    }
}
