package main.main.services;

import main.main.Entity.UserEntity;
import main.main.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserDto userDto);

//    void save(UserDto userDto);

    Boolean checkPasswordUser(String email, String password);
    Boolean checkUserbyEmail(String email);
    UserEntity getUserbyEmail(String email);
}
