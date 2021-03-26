package com.mycomp.billeezz.zuulapiserver.Security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements  UserDetailsService{
	MyUserDetailsService(){
		System.out.println("MyUserDetailsService");
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		return new User("Sri","Sri123",new ArrayList<>());
	}

}
