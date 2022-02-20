package com.viceri.api.dto;

import com.viceri.api.enums.Priority;

import lombok.Getter;

@Getter
public final class TaskUpdateDto {
	private Long taskId;
	private String description;
	private Priority priority;
}
