package com.ust.pms.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource datasource;
	
	//Enable JDBC authentication
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		
		
		authenticationManagerBuilder.jdbcAuthentication().dataSource(datasource);
	}

	// autherization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/register").permitAll() //forgotPasswordForm
		.antMatchers("/forgotPasswordForm").permitAll() 
		.antMatchers("/forgotPassword").permitAll() 
		//.antMatchers("http://localhost:6060/changePassword").permitAll() 
		.antMatchers("/index").hasAnyRole("USER")
				.antMatchers("/productList").hasAnyRole("USER","ADMIN")
				.antMatchers("/customer").hasAnyRole("ADMIN")
				.antMatchers("/").hasAnyRole("USER")
				.antMatchers("/admin").hasAnyRole("ADMIN")

				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
				.permitAll();
		// cross site request frogeery
		http.csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(datasource);
		return jdbcUserDetailsManager;
	}

}
