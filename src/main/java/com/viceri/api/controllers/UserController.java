package com.viceri.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viceri.api.models.dto.UserCreateDto;
import com.viceri.api.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Users")
@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping(value = "save")
	@ApiOperation(value = "save")
	public ResponseEntity<Void> save(@RequestBody final UserCreateDto dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		service.save(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
