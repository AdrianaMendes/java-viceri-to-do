package com.viceri.api.models.dto;

import com.viceri.api.models.enums.Priority;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public final class TaskCreateDto {
	@ApiModelProperty(value = "Descrição", example = "Tarefa genérica")
	private String description;
	
	@ApiModelProperty(value = "Prioridade", example = "LOW")
	private Priority priority;
}
