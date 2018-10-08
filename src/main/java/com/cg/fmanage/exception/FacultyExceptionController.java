package com.cg.fmanage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FacultyExceptionController {
	@ExceptionHandler(value = FacultyNotFoundException.class)
	   public ResponseEntity<Object> exception(FacultyNotFoundException exception) {
	      return new ResponseEntity<>("Faculty not found", HttpStatus.NOT_FOUND);
	   }
}
