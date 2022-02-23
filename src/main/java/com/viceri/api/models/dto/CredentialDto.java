package com.viceri.api.models.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class CredentialDto {

	@ApiModelProperty(value = "E-mail", example = "teste@email.com")
	private String email;
	
	@ApiModelProperty(dataType = "java.lang.String", value = "Senha", example = "1234abcd")
	private String password;
}
