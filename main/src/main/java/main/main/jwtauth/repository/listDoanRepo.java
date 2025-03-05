package main.main.jwtauth.repository;

import main.main.jwtauth.model.listDoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface listDoanRepo extends JpaRepository <listDoan ,Long> {
}
