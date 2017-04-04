package br.com.junior.pizzaria;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Aplicacao implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		   AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		   applicationContext.setConfigLocation("br.com.junior.pizzaria.config");
		   
		   Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(applicationContext));
		   appServlet.setLoadOnStartup(1);
		   appServlet.addMapping("/app/*");
		   
		   servletContext.addListener(new ContextLoaderListener(applicationContext));
	}
  
}
