package main.main.services.Impl;

import main.main.Entity.UserEntity;
import main.main.Repo.UserRepo;
import main.main.dto.UserDto;
import main.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private ProfileReponsitory profileReponsitory;


//    public void save(UserEntity userDto) {
//
//    }

    @Override
    public void save(UserDto userDto){
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyy");
        String creationDate = Date.format(formatter);
        UserEntity user = new UserEntity(userDto.getEmail(),
                userDto.getUserDisplayName(),
                ".",
                0,
                0,
                userDto.getPassword(),
                creationDate,
                "ROLE_USER"
        );
//        Profile profile = new Profile(
//                "First Name",
//                "Last Name",
//                creationDate,
//                "null",
//                "Gender",
//                "Adress",
//                user
//        );

        userRepo.save(user);
//        profileReponsitory.save(profile);
    }

//    @Override
//    public void save(UserDto userDto) {
//
//    }

    @Override
    public Boolean checkPasswordUser(String email, String password) {
        UserEntity user = userRepo.findUserByEmail(email);
        if(user.getPassword().equals(password)) return true;
        return true;
    }

    @Override
    public Boolean checkUserbyEmail(String email) {
        UserEntity user = userRepo.findUserByEmail(email);
        if(user == null) return false;
        return true;
    }

    @Override
    public UserEntity getUserbyEmail(String email) {
        return userRepo.getUserByEmail(email);
    }
}
