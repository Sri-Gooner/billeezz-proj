package com.mycomp.billeezz.zuulapiserver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.billeezz.zuulapiserver.Security.AuthenticationRequest;
import com.mycomp.billeezz.zuulapiserver.Security.AuthenticationResponse;
import com.mycomp.billeezz.zuulapiserver.Security.JwtUtil;

@RestController
public class MyZuulController {
	MyZuulController(){
		System.out.println("MyZuulController");
	}
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/")
	public String getBaseScreen(HttpServletRequest request){
		return "Hello";
	}
	
	@GetMapping("/hello")
	public String getHelloScreen(HttpServletRequest request){
		return "Hello World";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), 
				authenticationRequest.getPassword()));
		}catch(BadCredentialsException e){
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
