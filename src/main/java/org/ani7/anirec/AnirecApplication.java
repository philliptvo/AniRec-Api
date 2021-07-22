package org.ani7.anirec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@RestController
public class AnirecApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnirecApplication.class, args);
	}

//	@Configuration
//	@EnableWebSecurity
//	public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable()
//					.authorizeRequests()
//					.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//					.anyRequest().authenticated()
//					.and()
//					.httpBasic();
//		}
//	}
}
