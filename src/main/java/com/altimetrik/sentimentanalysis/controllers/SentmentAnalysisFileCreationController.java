package com.altimetrik.sentimentanalysis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.sentimentanalysis.commonutils.FileOperationUtils;
import com.altimetrik.sentimentanalysis.commonutils.FilePropertiesUtils;

@RestController
@RequestMapping("/fileOperations/")
public class SentmentAnalysisFileCreationController{

	Logger log = LoggerFactory.getLogger(SentmentAnalysisFileCreationController.class);
	 
    @Autowired
    FilePropertiesUtils fifilePathleOperationUtils;
     
    private String FILE_PATH=null;
	
	@GetMapping(path = "{fileKeyword}")
	public ResponseEntity<String> fileCreationOnDynamicSearchKeyword(@PathVariable String fileKeyword) {
	    
		FILE_PATH=fifilePathleOperationUtils.getFilePath();
	  
		try {
			 if((fileKeyword !=null && !fileKeyword.isEmpty()) && FILE_PATH !=null ) {
		     log.info("INSDIE Try ==> class : SentmentAnalysisFileCreationController , Method : "
		     		+ "fileCreationOnDynamicSearchKeyword() , the Keyword is "+fileKeyword +FILE_PATH) ;
			 boolean isFileCreated=FileOperationUtils.createFile(fileKeyword, fifilePathleOperationUtils); 
			 if(isFileCreated) 
			 return ResponseEntity.status(HttpStatus.CREATED).build();
			 }
		} catch (Exception e) {
			 log.error("INSDIE catch ==> class : SentmentAnalysisFileCreationController , Method : fileCreationOnDynamicSearchKeyword() , the Keyword is "+fileKeyword,e);
			 return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	
	
	 
	
	
	
}
