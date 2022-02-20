package com.viceri.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viceri.api.dto.UserCreateDto;
import com.viceri.api.entities.UserEntity;
import com.viceri.api.services.UserService;

import io.swagger.annotations.Api;

@Api(tags = "Users")
@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(name = "find-all")
	public ResponseEntity<List<UserEntity>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@PostMapping(name = "save")
	public ResponseEntity<Void> save(@RequestBody final UserCreateDto dto) {
		service.save(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
