package com.viceri.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.viceri.api.models.dto.UserCreateDto;
import com.viceri.api.models.entities.UserEntity;
import com.viceri.api.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public void save(final UserCreateDto dto) {
		repository.save(new UserEntity(dto));
	}

	public UserEntity getUserOnline() {
		final String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return repository.findByEmail(email).orElse(null);
	}

}
