package com.viceri.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
	LOW(0, "Baixo"), MEDIUM(1, "Médio"), HIGH(2, "Alto");

	private final Integer id;
	private final String description;
}
