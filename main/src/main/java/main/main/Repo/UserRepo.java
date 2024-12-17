package main.main.Repo;

import main.main.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserByEmail(String email);
    UserEntity getUserByEmail(String email);

    @Query(
            value = "select * from dbo_users",
            nativeQuery = true)
    List<UserEntity> getAllUser();
}
