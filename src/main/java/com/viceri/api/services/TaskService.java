package com.viceri.api.services;

import java.util.List;

import javax.transaction.Transactional;

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
		final UserEntity user = userService.getUserOnline();
		repository.save(new TaskEntity(dto, user.getId()));
	}

	public TaskEntity findById(final Long id) {
		final UserEntity user = userService.getUserOnline();
		return repository.findByUserIdAndId(user.getId(), id).orElse(null);
	}

	public void update(final TaskUpdateDto dto) {
		final UserEntity user = userService.getUserOnline();
		TaskEntity entity = repository.findByUserIdAndId(user.getId(), dto.getTaskId()).orElse(null);
		repository.save(entity.update(dto));
	}

	public void taskDone(final Long id) {
		final UserEntity user = userService.getUserOnline();
		TaskEntity entity = repository.findByUserIdAndId(user.getId(), id).orElse(null);
		entity.setDone();
		repository.save(entity);
	}

	@Transactional
	public void delete(final Long id) {
		final UserEntity user = userService.getUserOnline();
		repository.deleteByUserIdAndId(user.getId(), id);
	}

	public List<TaskEntity> findNotDoneTask(final Priority priority) {
		final UserEntity user = userService.getUserOnline();
		return priority == null ? repository.findByUserIdAndIsDoneFalse(user.getId())
				: repository.findByUserIdAndIsDoneFalseAndPriority(user.getId(), priority);
	}
}
