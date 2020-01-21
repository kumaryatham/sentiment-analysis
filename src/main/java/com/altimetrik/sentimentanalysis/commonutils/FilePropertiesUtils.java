package com.altimetrik.sentimentanalysis.commonutils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@ConfigurationProperties(prefix = "app.keyword")
@Configuration
public class FilePropertiesUtils {  

	
	private String filePath;
	private String hostDir;
	private String hostname;
	private String userName;
	private String password;

	
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
		System.out.print("Dev Created"+this.filePath);
		return "Stage Created";
	}
	
	@Profile("dev")
	@Bean
	public String decProsDev() {
		System.out.print("Dev Created"+this.filePath);
		return "Dev Created";
	}
	@Profile("test")
	@Bean
	public String decProsTest() {
		System.out.print("Test Created"+this.filePath);
		return "Test Created";
	}
	@Profile("prod")
	@Bean
	public String decProsProd() {
		System.out.print("Prod Created"+this.filePath);
		return "Prod Created";
	}
	
}
	
