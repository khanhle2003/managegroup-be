package main.main.AddData.repo;

import main.main.AddData.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepo extends JpaRepository<Data,Integer> {

}
