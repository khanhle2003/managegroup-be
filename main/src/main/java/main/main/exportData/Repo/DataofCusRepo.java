package main.main.exportData.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import main.main.exportData.Entity.DataofCusEntity;

public interface DataofCusRepo extends JpaRepository<DataofCusEntity, Long> {
}