package br.com.lepsistemas.springbootjwt.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedResource {
	
	@GetMapping
	public String protectedResource() {
		return "protected";
	}

}
