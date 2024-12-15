package main.main.Controller;

import main.main.Entity.UserEntity;
import main.main.services.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/input")
public class InputController {
    @Autowired
    private UserSevice userService;

    @PostMapping
    public ResponseEntity<String> inputUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User saved successfully");
    }
}
