package com.viceri.api.models.dto;

import com.viceri.api.models.enums.Priority;

import lombok.Getter;

@Getter
public final class TaskCreateDto {
	private String description;
	private Priority priority;
	private Long userId;
}
