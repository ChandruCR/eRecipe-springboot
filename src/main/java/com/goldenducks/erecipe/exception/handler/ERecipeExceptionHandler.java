package com.goldenducks.erecipe.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.goldenducks.erecipe.exception.ERecipeException;

@ControllerAdvice
@RestController
public class ERecipeExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = ERecipeException.class)
	public String handleBaseException(ERecipeException e) {
		return e.getMessage();
	}

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		return e.getMessage();
	}

}