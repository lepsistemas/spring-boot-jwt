package br.com.lepsistemas.springbootjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lepsistemas.springbootjwt.domain.User;
import br.com.lepsistemas.springbootjwt.repository.UserRepository;
import br.com.lepsistemas.springbootjwt.security.UserSecurity;

@Service
public class UserSecurityService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserSecurity(user.getId(), user.getUsername(), user.getPassword());
	}

}
