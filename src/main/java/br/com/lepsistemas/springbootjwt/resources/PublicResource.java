package br.com.lepsistemas.springbootjwt.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicResource {
	
	@GetMapping
	public String publicResource() {
		return "public";
	}

}
