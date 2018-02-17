package br.com.lepsistemas.springbootjwt.service;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.lepsistemas.springbootjwt.security.UserSecurity;

public class UserService {

	public static UserSecurity authenticated() {
		try {
			return (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
