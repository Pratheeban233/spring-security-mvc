package com.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.inMemoryAuthentication().withUser("Prathi")
//				.password("{bcrypt}$2a$10$ez2EUDXOyKGemUm901luZeZAUwLv5ctUdXr4CQJWVYOYfzRQ3s08S") // Prathi123
//				.roles("Admin")
//				.and()
//				.withUser("abiya")
//				.password("{noop}abiya123")
//				.roles("user");
		
		
		auth.jdbcAuthentication().dataSource(datasource); //password encoder mentioned in DB

	}
	
/*	@Bean
	public PasswordEncoder getPasscodeEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}*/

	  //return new BCryptPasswordEncoder(); }
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/welcome","/hello").authenticated()
		.antMatchers("/bye").permitAll()
		.and()
		  .formLogin().loginPage("/login").loginProcessingUrl("/process-login")
		  .and()
		  .httpBasic().and().logout();

	}

}
