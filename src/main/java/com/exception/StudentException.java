package com.exception;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentException {
	
	Logger logger = LoggerFactory.getLogger(StudentException.class);
	
	@ExceptionHandler(value = badRequestException.class)
		public ResponseEntity<Object> badRequestexception(){
		logger.debug("custom badRequestException response is sent");
			return new ResponseEntity<Object>("bad request sent",HttpStatus.BAD_REQUEST);
		}
	
	
	
	@ExceptionHandler(badInputFieldsException.class)
	public HashMap<String,String> badInputFieldsException(){
		logger.debug("custom badInputFieldsException response is sent");
		HashMap<String,String> hm = new HashMap<String,String>();
	     hm.put("input 1","bad input parameter");
		
		return hm;
		
	}
	}


	

