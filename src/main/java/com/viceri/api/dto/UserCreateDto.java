package com.viceri.api.dto;

import lombok.Getter;

@Getter
public final class UserCreateDto {
	private String name;
	private String email;
	private String password;
}
