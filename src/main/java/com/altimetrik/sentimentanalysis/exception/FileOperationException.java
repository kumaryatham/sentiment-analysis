package com.altimetrik.sentimentanalysis.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileOperationException extends RuntimeException {
		   private static final long serialVersionUID = 1L;
		   Logger log = LoggerFactory.getLogger(FileOperationException.class);
		   public FileOperationException(String msg){
			   super(msg);
			   log.info("FileOperationException user defined exception has been called");
		   }
}