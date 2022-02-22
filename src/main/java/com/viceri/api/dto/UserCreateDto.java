package com.viceri.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class UserCreateDto {
	private String name;
	private String email;
	private String password;
}
