package main.main.exportData.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import main.main.exportData.Entity.DataofCusEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataofCusRepo extends JpaRepository<DataofCusEntity, Long> {
    // Truy vấn tính trung bình số ngày theo năm

}