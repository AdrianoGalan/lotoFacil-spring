package br.com.ngfor.lotofacil.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ngfor.lotofacil.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
