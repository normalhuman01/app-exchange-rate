package pe.com.test.challenge.infrastructure.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import pe.com.test.challenge.domain.exception.CurrencyNotFoundException;
import pe.com.test.challenge.domain.exception.UserNotFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({UserNotFoundException.class, CurrencyNotFoundException.class})
    protected ProblemDetail handleNotFound(RuntimeException ex) {

        log.error(ex.toString());

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Resource not found");

        return problemDetail;
    }


}