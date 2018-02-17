package br.com.lepsistemas.springbootjwt.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lepsistemas.springbootjwt.security.JWTUtil;
import br.com.lepsistemas.springbootjwt.security.UserSecurity;
import br.com.lepsistemas.springbootjwt.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/refresh")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSecurity user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}

}
