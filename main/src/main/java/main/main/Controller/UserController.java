package main.main.Controller;

import ch.qos.logback.core.net.SMTPAppenderBase;
import main.main.Entity.UserEntity;
import main.main.services.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import main.main.Repo.UserRepo;
import java.util.List;

@Controller
@RequestMapping("/api/auth")
public class UserController {
    private final UserSevice userService;

    public UserController(UserSevice userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserEntity user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity user) {
        try {
            userService.loginUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok("Login successful");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
//    try {
//        SMTPAppenderBase<Object> loginRequest;
//        UserEntity user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
//        return ResponseEntity.ok(user);
//    } catch (RuntimeException e) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//    }
}

