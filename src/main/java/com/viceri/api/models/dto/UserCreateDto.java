package com.viceri.api.models.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class UserCreateDto {
	
	@ApiModelProperty(value = "Nome", example = "Nome")
	private String name;
	
	@ApiModelProperty(value = "E-mail", example = "E-mail")
	private String email;
	
	@ApiModelProperty(value = "Senha", example = "Senha")
	private String password;
}
