package com.viceri.api.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class UserCreateDto {
	private String name;
	private String email;
	private String password;
}
