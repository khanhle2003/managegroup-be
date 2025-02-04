package main.main.thongke.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.main.table2.doanra.Entity.DoanRaEntity;


@Repository
public interface thongkerepo2 extends JpaRepository<DoanRaEntity, Integer> {
   @Query(value = "SELECT * FROM data9 WHERE tu_ngay LIKE %:year% AND quoc_tich IN :countries", 
          nativeQuery = true)
   List<DoanRaEntity> findByYearAndCountries(
       @Param("year") String year,
       @Param("countries") List<String> countries
   );
   
   @Query(value = "SELECT quoc_tich, COUNT(*) as count " +
                  "FROM data9 " +
                  "WHERE tu_ngay LIKE %:year% AND quoc_tich IN :countries " +
                  "GROUP BY quoc_tich", 
          nativeQuery = true)
   List<Object[]> countByYearAndCountries(
       @Param("year") String year,
       @Param("countries") List<String> countries
   );
}

