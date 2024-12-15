package main.main.Controller;

import main.main.Entity.UserEntity;
import main.main.services.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    private UserSevice userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> searchUsers(@RequestParam String query) {
        List<UserEntity> users = userService.searchUsers(query);
        return ResponseEntity.ok(users);
    }
}
