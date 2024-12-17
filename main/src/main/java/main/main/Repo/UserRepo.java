package main.main.Repo;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import main.main.Entity.UserEntity;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
//    UserEntity findByUsername(String username);
//
//    List<UserEntity> findByUsernameContaining(String username);


    UserEntity findUserByEmail(String email);
    UserEntity getUserByEmail(String email);

    @Query(
            value = "select * from dbo_users",
            nativeQuery = true)
    List<User> getAllUser();

}


