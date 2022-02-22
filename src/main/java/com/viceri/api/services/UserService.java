package com.viceri.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viceri.api.models.dto.UserCreateDto;
import com.viceri.api.models.entities.UserEntity;
import com.viceri.api.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserEntity> findAll() {
		return repository.findAll();
	}

	public void save(final UserCreateDto dto) {
		repository.save(new UserEntity(dto));
	}

}
