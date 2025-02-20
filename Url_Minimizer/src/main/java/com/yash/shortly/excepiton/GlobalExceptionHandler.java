package com.yash.shortly.excepiton;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
	    Map<String, String> response = new HashMap<>();
	    response.put("error", ex.getMessage());
	    return ResponseEntity.badRequest().body(response);
	}

}
