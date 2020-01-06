package com.codegeas.projects.project1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration  
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override  
    public void configure(HttpSecurity http) throws Exception {  
		http  
	    .authorizeRequests()  
	        .antMatchers("/").permitAll()
	        .antMatchers( "/public/**").permitAll()  
	        .anyRequest().authenticated()  
        .and()  
	        .formLogin()  
	            .loginPage("/login") 
	            // if the authentication failed, it will stay in the same login page...
	            // .. and add "?error" in its url
	            .loginProcessingUrl("/authenticateTheUser")  
	            .permitAll()
         .and()
	         .logout()
	         // if the logout succeed, it will redirect to index-page...
	         // ...and add "?logout" in its url
		         .logoutSuccessUrl("/?logout")
		         .permitAll();  
    }  
	
    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
        auth.inMemoryAuthentication()  
            .withUser("user")  
            .password("{noop}pass") // Spring Security 5 requires specifying the password storage format  
            .roles("USER");  
    }  
}