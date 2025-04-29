package ukim.finki.mk.lab1.security;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ukim.finki.mk.lab1.dto.JWTExceptionResponse;

import java.security.SignatureException;

@RestControllerAdvice
@Hidden
public class JWTExceptionHandler {
    private ResponseEntity<JWTExceptionResponse> buildJwtExceptionResponse(
            HttpStatus status,
            String message,
            String path
    ) {
        return new ResponseEntity<>(
                new JWTExceptionResponse(
                        status.value(),
                        status.getReasonPhrase(),
                        message,
                        path
                ),
                status
        );
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<JWTExceptionResponse> handleExpiredJwtException(
            ExpiredJwtException expiredJwtException,
            HttpServletRequest request
    ) {
        return buildJwtExceptionResponse(
                HttpStatus.UNAUTHORIZED,
                "The token has expired.",
                request.getRequestURI()
        );
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<JWTExceptionResponse> handleSignatureException(
            SignatureException exception,
            HttpServletRequest request
    ) {
        return buildJwtExceptionResponse(
                HttpStatus.UNAUTHORIZED,
                "The token's signature is invalid.",
                request.getRequestURI()
        );
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<JWTExceptionResponse> handleJwtException(
            JwtException exception,
            HttpServletRequest request
    ) {
        return buildJwtExceptionResponse(
                HttpStatus.UNAUTHORIZED,
                "The token is invalid.",
                request.getRequestURI()
        );
    }

}
