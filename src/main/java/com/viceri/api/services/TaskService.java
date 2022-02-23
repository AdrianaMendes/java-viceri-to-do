package com.viceri.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viceri.api.models.dto.TaskCreateDto;
import com.viceri.api.models.dto.TaskUpdateDto;
import com.viceri.api.models.entities.TaskEntity;
import com.viceri.api.models.entities.UserEntity;
import com.viceri.api.models.enums.Priority;
import com.viceri.api.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private UserService userService;

	public void save(final TaskCreateDto dto) {
		repository.save(new TaskEntity(dto));
	}

	public TaskEntity findById(final Long id) {		
		final UserEntity user = userService.getUserOnline();
		return repository.findByIdAndUserId(id, user.getId()).orElse(null);
	}

	public void update(final TaskUpdateDto dto) {
		TaskEntity entity = repository.findById(dto.getTaskId()).orElse(null);
		repository.save(entity.update(dto));
	}

	public void taskDone(final Long id) {
		TaskEntity entity = repository.findById(id).orElse(null);
		entity.setDone();
		repository.save(entity);
	}

	public void delete(final Long id) {
		repository.deleteById(id);
	}

	public List<TaskEntity> findNotDoneTask(final Long userId, final Priority priority) {
		return priority == null ? repository.findByUserIdAndIsDoneFalse(userId)
				: repository.findByUserIdAndIsDoneFalseAndPriority(userId, priority);
	}
}
