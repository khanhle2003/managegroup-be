package main.main.jwtauth.service;

import main.main.jwtauth.util.JwUtil;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String generateToken(String username) {
        return JwUtil.generateToken(username);
    }

    public boolean validateToken(String token) {
        return JwUtil.validateToken(token);
    }

    public String extractUsername(String token) {
        return JwUtil.extractUsername(token);
    }
}
