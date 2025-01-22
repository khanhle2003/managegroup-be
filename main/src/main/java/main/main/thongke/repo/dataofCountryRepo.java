package main.main.thongke.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import main.main.exportData.Entity.DataofCusEntity;

@Repository
public interface dataofCountryRepo extends JpaRepository<DataofCusEntity, Integer> {
    @Query("SELECT DISTINCT d.Country FROM DataofCusEntity d")
    List<String> findDistinctCountries();




    @Query("SELECT DISTINCT d.InvitationUnit FROM DataofCusEntity d")
    List<String> findDistinctInvitationUnits();
}