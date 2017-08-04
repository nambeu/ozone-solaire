package com.paperjais.ozone;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OzoneSolaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(OzoneSolaireApplication.class, args);
	}
	
	@RequestMapping(value="/user")
	public Principal getPrincipal(Principal user){
		return user;
	}
	
	/*
	@RequestMapping(value="/deconnection")
	public void logout(){
		SecurityContextHolder.clearContext();
	}  */
}
