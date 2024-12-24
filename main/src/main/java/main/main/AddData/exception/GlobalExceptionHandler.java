package main.main.AddData.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DateTimeParseException.class)
    ResponseEntity<String> datetimeParseExceptionHandler(DateTimeParseException exception){
        return ResponseEntity.badRequest().body("Date type must be yyyy-MM-dd");
    }
}
