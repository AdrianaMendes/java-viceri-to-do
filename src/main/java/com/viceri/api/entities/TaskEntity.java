package com.viceri.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.viceri.api.dto.TaskCreateDto;
import com.viceri.api.dto.TaskUpdateDto;
import com.viceri.api.enums.Priority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public final class TaskEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "priority")
	private Priority priority;

	@Column(name = "is_done")
	private Boolean isDone = false;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	public TaskEntity(final TaskCreateDto dto) {
		id = null;
		user = new UserEntity();
		user.setId(dto.getUserId());
		description = dto.getDescription();
		priority = dto.getPriority();
	}
	
	public TaskEntity update(final TaskUpdateDto dto) {
		priority = dto.getPriority();
		description = dto.getDescription();
		return this;
	}
	
	public void setDone() {
		isDone = true;
	}
}
