package spring.boot.hello_world.framework.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import spring.boot.hello_world.mvc.service.CustomUserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	UserDetailsService customUserService() {
		return new CustomUserService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("开始执行WebSecurityConfig");
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.failureUrl("/login?error").permitAll().and().logout().permitAll();
	}
}
