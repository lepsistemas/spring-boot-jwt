package br.com.lepsistemas.springbootjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.lepsistemas.springbootjwt.domain.User;
import br.com.lepsistemas.springbootjwt.domain.User.UserBuilder;
import br.com.lepsistemas.springbootjwt.repository.UserRepository;

@Service
public class InitialLoadService {
	
	@Autowired
	private BCryptPasswordEncoder crypt;
	
	@Autowired
	private UserRepository userRepository;
	
	public void initialLoadDatabase() {
		User user = new UserBuilder().username("root").password(crypt.encode("root")).build();
		userRepository.save(user);
	}

}
