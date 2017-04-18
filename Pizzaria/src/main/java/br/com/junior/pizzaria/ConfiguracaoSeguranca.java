package br.com.junior.pizzaria;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("PIZZARIA");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/app/pizzas/**","/app/ingredientes/**")
		.hasRole("PIZZARIA").anyRequest().permitAll()
		.and()
			.formLogin()
				.loginPage("/login.jsp")
				.usernameParameter("usuario")
				.passwordParameter("senha")
				.loginProcessingUrl("/autenticar")
				.defaultSuccessUrl("/app/pizzas")
				.failureUrl("/login.jsp?semacesso=true")
		.and()
			.logout()
				.logoutUrl("/sair")
				.logoutSuccessUrl("/login.jsp?saiu=true");
		
	}
}