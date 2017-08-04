package com.paperjais.ozone;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Controller
public class WebMvcConfig {
 /*  extends WebMvcConfigurerAdapter   
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
	//	super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("login");
	}
	
	*/
	  @RequestMapping(value="/login")
	  public String login(){
		  return "login";
	  }
	  
	  @RequestMapping(value="/logout")
	  public String logout(){
		  SecurityContextHolder.clearContext();
		  return "login";
	  }  
}
