//
////package com.example.demo.authentication;
//
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.http.HttpMethod;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.authentication.AuthenticationProvider;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.builders.WebSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////
////@Configuration
////@EnableWebSecurity
//public class AppSecurityConfig {
////	@Autowired
////	UserDetailsService userDetailsService;
////
////	@Bean
////	public AuthenticationProvider authProvider() {
////		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
////		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
////		return daoAuthenticationProvider;
////	}
////
////	protected void configure(HttpSecurity httpSecurity) throws Exception {
////		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/*").permitAll()
////				.anyRequest().authenticated().and().httpBasic();
////
////	}
////}
