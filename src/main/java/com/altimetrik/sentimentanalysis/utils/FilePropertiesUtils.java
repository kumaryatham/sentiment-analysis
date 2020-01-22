package com.altimetrik.sentimentanalysis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@ConfigurationProperties(prefix = "app.keyword")
@Configuration
public class FilePropertiesUtils {  
   
	Logger log = LoggerFactory.getLogger(FilePropertiesUtils.class);
	
	private String filePath;
	private String hostDir;
	private String hostname;
	private String userName;
	private String password;
    private String ftpEnabled;
    
    
    

	
	public String getFtpEnabled() {
		return ftpEnabled;
	}

	public void setFtpEnabled(String ftpEnabled) {
		this.ftpEnabled = ftpEnabled;
	}

	public String getHostDir() {
		return hostDir;
	}

	public void setHostDir(String hostDir) {
		this.hostDir = hostDir;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Profile("stage")
	@Bean
	public String decPros() {
		log.info("STAGE profile got Activated");
		return "Stage Created";
	}
	
	@Profile("dev")
	@Bean
	public String decProsDev() {
		log.info("DEV profile got Activated");
		return "Dev Created";
	}
	@Profile("test")
	@Bean
	public String decProsTest() {
		log.info("TEST profile got Activated");
		return "Test Created";
	}
	@Profile("prod")
	@Bean
	public String decProsProd() {
		log.info("PROD profile got Activated");
		return "Prod Created";
	}
	
}
	
