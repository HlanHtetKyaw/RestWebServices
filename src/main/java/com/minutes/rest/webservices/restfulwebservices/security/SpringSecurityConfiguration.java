package com.minutes.rest.webservices.restfulwebservices.security;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	@SuppressWarnings("deprecation")
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeRequests(auth->auth.anyRequest().authenticated());
		http.httpBasic(withDefaults());
		http.csrf().disable();
		return http.build();
	}
}
