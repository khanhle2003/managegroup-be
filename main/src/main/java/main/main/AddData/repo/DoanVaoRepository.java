package main.main.AddData.repo;

import main.main.table2.doanra.Entity.DoanRaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoanVaoRepository extends JpaRepository<DoanRaEntity, Integer> {
}
