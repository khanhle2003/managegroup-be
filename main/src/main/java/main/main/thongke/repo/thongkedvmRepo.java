package main.main.thongke.repo;

import main.main.exportData.Entity.DataofCusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface thongkedvmRepo extends JpaRepository<DataofCusEntity, Integer> {
    
    @Query(value = "SELECT * FROM tonghop WHERE invitation_unit IN :invitationUnits AND start_date LIKE %:year%", 
           nativeQuery = true)
    List<DataofCusEntity> findByInvitationUnitsAndYear(
        @Param("invitationUnits") List<String> invitationUnits,
        @Param("year") String year
    );
    
    @Query(value = "SELECT COUNT(*) FROM tonghop WHERE invitation_unit IN :invitationUnits AND start_date LIKE %:year%", 
           nativeQuery = true)
    Long countByInvitationUnitsAndYear(
        @Param("invitationUnits") List<String> invitationUnits,
        @Param("year") String year
    );
}
