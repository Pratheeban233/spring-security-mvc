package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
		.inMemoryAuthentication()
		.withUser("Prathi")
		.password("{bcrypt}$2a$10$rYgKaEwBXGqnPlCVzW7NaOf13GBIYtHmxmNmyzNWbgJ6peN.RPQMO")
		.roles("Admin");
		
	}
	
	/*@Bean
	public PasswordEncoder getPasscodeEncoder() {
	
		return NoOpPasswordEncoder.getInstance();
		
		//return new BCryptPasswordEncoder();
	}*/

}
