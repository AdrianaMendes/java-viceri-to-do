package com.viceri.api.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.viceri.api.entities.UserEntity;
import com.viceri.api.repositories.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		final Optional<UserEntity> user = repository.findByEmail(email);

		if (user.isEmpty()) {
			throw new UsernameNotFoundException(email);
		}

		return new UserDetailsData(user);
	}

}
