package main.main.jwtauth.controller;


import main.main.jwtauth.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import main.main.jwtauth.model.User;
import main.main.jwtauth.service.UserService;
import main.main.jwtauth.util.JwtUtils;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("Đăng kí thành công");
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            // Retrieve the authenticated user and generate JWT
            User authenticatedUser = userService.findByUsername(user.getUsername()).orElseThrow(() -> new AuthenticationException("Invalid credentials") {});
            String jwt = jwtUtils.generateToken(authenticatedUser);

            return ResponseEntity.ok(jwt);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String username) {
        String token = jwtService.generateToken(username);
        return ResponseEntity.ok(token);
    }

    @PostMapping("auth/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String oldToken) {
        if (jwtService.validateToken(oldToken.substring(7))) {
            String username = jwtService.extractUsername(oldToken.substring(7));
            String newToken = jwtService.generateToken(username);
            return ResponseEntity.ok(newToken);
        }
        return ResponseEntity.status(401).body("Token không hợp lệ hoặc hết hạn");
    }
}
