package main.main.exportData.Repo;
import main.main.exportData.Entity.DataofCusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface userdetailRepo extends JpaRepository<DataofCusEntity, Long> {
}