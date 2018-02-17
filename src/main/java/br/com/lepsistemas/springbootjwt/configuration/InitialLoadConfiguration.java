package br.com.lepsistemas.springbootjwt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lepsistemas.springbootjwt.service.InitialLoadService;

@Configuration
public class InitialLoadConfiguration {
	
	@Autowired
	private InitialLoadService initialLoadService;
	
	@Bean
	public boolean initialLoad() {
		initialLoadService.initialLoadDatabase();
		return true;
	}

}
