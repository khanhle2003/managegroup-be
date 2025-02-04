package main.main.exportData.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import main.main.exportData.Entity.DataofCusEntity;

import org.springframework.stereotype.Repository;
@Repository
public interface DataofCusRepo extends JpaRepository<DataofCusEntity, Long> {
    // Truy vấn tính trung bình số ngày theo năm

}