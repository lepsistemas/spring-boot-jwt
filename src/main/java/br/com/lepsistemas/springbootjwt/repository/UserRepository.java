package br.com.lepsistemas.springbootjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lepsistemas.springbootjwt.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional
	User findByUsername(String username);

}
