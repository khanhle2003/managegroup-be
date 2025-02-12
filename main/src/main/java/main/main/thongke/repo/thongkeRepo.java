package main.main.thongke.repo;


import main.main.exportData.Entity.DataofCusEntity;
import main.main.table2.doanra.Entity.DoanRaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface thongkeRepo extends JpaRepository<DataofCusEntity, Integer> {

   
    @Query(value = "SELECT * FROM data WHERE country IN :countries AND start_date LIKE %:year%", 
           nativeQuery = true)
    List<DataofCusEntity> findByCountriesAndYear(
        @Param("countries") List<String> countries,
        @Param("year") String year
    );
    
    @Query(value = "SELECT COUNT(*) FROM data WHERE country IN :countries AND start_date LIKE %:year%", 
           nativeQuery = true)
    Long countByCountriesAndYear(
        @Param("countries") List<String> countries,
        @Param("year") String year
    );




}