package com.example.jpa_api.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers(HttpMethod.OPTIONS, "*//**")
				.antMatchers("/resources/static/**")
				.antMatchers("/css*//**")
				.antMatchers("/fonts*//**")
				.antMatchers("/img*//**")
				.antMatchers("/js*//**")
				.antMatchers("/index.html")
				.antMatchers("/robots.txt");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.anyRequest()
				.permitAll();
	}
}
