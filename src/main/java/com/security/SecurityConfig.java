//package com.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import net.bytebuddy.build.Plugin.Engine.Source.InMemory;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	
//    InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//   UserDetails user =User.withUsername("akash").password(bCryptPasswordEncoder.encode("mypassword")).roles("read").build();
//   userDetailsService.createUser(user);
//    
//	  auth.userDetailsService(userDetailsService).passwordEncoder( bCryptPasswordEncoder);		
//	}
//	
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//	
//    http.httpBasic();
//	http.authorizeRequests().anyRequest().authenticated();
//}
//
//
//}
