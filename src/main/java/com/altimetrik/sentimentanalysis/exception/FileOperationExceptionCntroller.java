package com.altimetrik.sentimentanalysis.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileOperationExceptionCntroller {
	Logger log = LoggerFactory.getLogger(FileOperationExceptionCntroller.class);
	@ExceptionHandler(value = FileOperationException.class)
	public ResponseEntity<String> exception(FileOperationException exception) {
		log.info("FileOperationExceptionCntroller has been initilized");
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
