/**
 * 
 */
package com.altimetrik.sentimentanalysis.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Kumara Swamy
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	@Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
	log.info("SecurityConfig.class inside configure method entered");	
	
		authenticationManagerBuilder.inMemoryAuthentication()
        .withUser("admin").password("yigepingguo.com").roles("ADMIN", "USER");
		
		log.info("SecurityConfig.class inside configure method ending");	
    }
	
/*	@Override
	public void configure(HttpSecurity http) {	
	}*/

}
