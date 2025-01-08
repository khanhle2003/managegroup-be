package main.main.jwtauth.service;

import main.main.jwtauth.model.listDoan;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface doanService {
    void save(MultipartFile file) throws IOException;
    List<listDoan> findAll = List.of();

    List<listDoan> findAll();
}
