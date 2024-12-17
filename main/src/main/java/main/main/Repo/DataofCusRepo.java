package main.main.Repo;

import main.main.Entity.DataofCusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataofCusRepo extends JpaRepository<DataofCusEntity, Long> {
}