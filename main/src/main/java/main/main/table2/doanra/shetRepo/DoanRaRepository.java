package main.main.table2.doanra.shetRepo;

import main.main.table2.doanra.Entity.DoanRaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoanRaRepository extends JpaRepository<DoanRaEntity, Integer> {
}