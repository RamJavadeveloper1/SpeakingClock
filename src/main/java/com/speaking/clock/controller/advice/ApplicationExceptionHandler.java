package com.speaking.clock.controller.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.speaking.clock.exception.InvalidTimeInputException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InvalidTimeInputException.class)
	public Map<String, String> handleInvalidTimeInput(InvalidTimeInputException ex){
		HashMap<String, String> errorMap= new HashMap<>(); 
		errorMap.put("ErrorMessage", ex.getMessage());
		return errorMap;
		
	}
}
