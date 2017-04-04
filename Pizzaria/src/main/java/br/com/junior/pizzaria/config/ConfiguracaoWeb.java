package br.com.junior.pizzaria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="br.com.junior.pizzaria")
public class ConfiguracaoWeb extends WebMvcConfigurerAdapter{
    
}
