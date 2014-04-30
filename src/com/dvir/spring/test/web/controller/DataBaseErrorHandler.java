package com.dvir.spring.test.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataBaseErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public String handleDataBaseException(DataAccessException ex) {
		ex.printStackTrace();
		return "error";
	}
}
