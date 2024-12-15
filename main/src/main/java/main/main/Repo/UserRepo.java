package main.main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.main.Entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    List<UserEntity> findByUsernameContaining(String username);
}


