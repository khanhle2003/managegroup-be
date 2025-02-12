package main.main.table2.doanra.shetRepo;

import main.main.exportData.Entity.DataofCusEntity;
import main.main.table2.doanra.Entity.DoanRaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userdetailRepo2 extends JpaRepository<DoanRaEntity, Long> {
}
