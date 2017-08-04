package com.paperjais.ozone;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);
		http.csrf().disable()
		   .authorizeRequests()
				.antMatchers("/image/**", "/js/**", "/vendor/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/index.html")
				.failureUrl("/login")
				.and()
			.logout()
			   .deleteCookies("remove")
			   .invalidateHttpSession(true)
			   .logoutUrl("/logout")
			   .logoutSuccessUrl("/login");
	}
}
