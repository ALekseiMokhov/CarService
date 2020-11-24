package com.senla.carservice.spring.exceptionhandlers;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice()
class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

  /*  Authentication exceptions*/
    @ExceptionHandler(value = SignatureException.class)
    @ResponseBody
    public ResponseEntity<String> handleSignatureException(Exception ex, WebRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("Handling Exception: " + ex);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
    @ExceptionHandler(value = MalformedJwtException.class)
    @ResponseBody
    public ResponseEntity<String> handleMalformedJwtException(Exception ex, WebRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("Handling Exception: " + ex);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
    @ExceptionHandler(value = ExpiredJwtException.class)
    @ResponseBody
    public ResponseEntity<String> handleExpiredJwtException(Exception ex, WebRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("Handling Exception: " + ex);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

  
    @ExceptionHandler(value = UnsupportedJwtException.class)
    @ResponseBody
    public ResponseEntity<String> handleIllegalArgumentException(Exception ex, WebRequest request) {
        if (log.isDebugEnabled()) {
            log.debug("Handling Exception: " + ex);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
