package com.altimetrik.sentimentanalysis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.sentimentanalysis.utils.FileOperationUtils;
import com.altimetrik.sentimentanalysis.utils.FilePropertiesUtils;

@RestController
@RequestMapping("/trendInitiater/")
public class SentmentAnalysisFileCreationController{

	Logger log = LoggerFactory.getLogger(SentmentAnalysisFileCreationController.class);
	 
    @Autowired
    FilePropertiesUtils fifilePathleOperationUtils;
     
    private String FILE_PATH=null;
    private static String IS_ENABLED="true";
	
	@PostMapping(path = "{fileKeyword}")
	public ResponseEntity<String> fileCreationOnDynamicSearchKeyword(@PathVariable String fileKeyword) {
	    
		FILE_PATH=fifilePathleOperationUtils.getFilePath();
		boolean isFileCreated=false;
		try {
			if (fifilePathleOperationUtils != null && (fileKeyword != null && !fileKeyword.isEmpty())
					&& FILE_PATH != null) {
				log.info("INSDIE Try ==> class : SentmentAnalysisFileCreationController , Method : "
						+ "fileCreationOnDynamicSearchKeyword() , the Keyword is " + fileKeyword + FILE_PATH);

				if (fifilePathleOperationUtils.getFtpEnabled().equals(IS_ENABLED)) {
					isFileCreated = FileOperationUtils.createFileByUsingFTP(fileKeyword, fifilePathleOperationUtils);
				} else {
					isFileCreated = FileOperationUtils.createFile(fileKeyword, fifilePathleOperationUtils);
				}
		     }
			if (isFileCreated)
				return ResponseEntity.status(HttpStatus.OK).build();
		    }
		  catch (Exception e) {
			 log.error("INSDIE catch ==> class : SentmentAnalysisFileCreationController , Method : fileCreationOnDynamicSearchKeyword() , the Keyword is "+fileKeyword,e);
			 return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
