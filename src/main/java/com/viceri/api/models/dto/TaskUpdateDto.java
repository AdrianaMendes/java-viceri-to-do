package com.viceri.api.models.dto;

import com.viceri.api.models.enums.Priority;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public final class TaskUpdateDto {
	@ApiModelProperty(value = "ID da tarefa")
	private Long taskId;
	
	@ApiModelProperty(value = "Descrição")
	private String description;
	
	@ApiModelProperty(value = "Prioridade")
	private Priority priority;
}
