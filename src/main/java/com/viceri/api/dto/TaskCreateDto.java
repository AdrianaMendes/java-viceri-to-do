package com.viceri.api.dto;

import com.viceri.api.enums.Priority;

import lombok.Getter;

@Getter
public final class TaskCreateDto {
	private String description;
	private Priority priority;
	private Long userId;
}
