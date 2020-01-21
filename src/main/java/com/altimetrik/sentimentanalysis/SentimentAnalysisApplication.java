package com.altimetrik.sentimentanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.altimetrik.sentimentanalysis.commonutils.FilePropertiesUtils;

@SpringBootApplication
public class SentimentAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentimentAnalysisApplication.class, args);
	}
	

}
