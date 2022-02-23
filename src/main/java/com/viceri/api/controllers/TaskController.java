package com.viceri.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viceri.api.models.dto.TaskCreateDto;
import com.viceri.api.models.dto.TaskUpdateDto;
import com.viceri.api.models.entities.TaskEntity;
import com.viceri.api.models.enums.Priority;
import com.viceri.api.services.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Tasks")
@RestController
@RequestMapping(value = "tasks")
public class TaskController {

	@Autowired
	private TaskService service;

	@PostMapping
	@ApiOperation(value = "Inclusão de uma nova tarefa")
	public ResponseEntity<Void> save(@RequestBody final TaskCreateDto dto) {
		service.save(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	@ApiOperation(value = "Selecionar uma nova tarefa")
	public ResponseEntity<TaskEntity> findById(@RequestParam final Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "find-not-done-task")
	@ApiOperation(value = "Listar as tarefas pendentes, filtrando opcionalmente pela prioridade")
	public ResponseEntity<List<TaskEntity>> findNotDoneTask(@RequestParam(required = false) final Priority priority) {
		return new ResponseEntity<>(service.findNotDoneTask(priority), HttpStatus.OK);
	}

	@PutMapping
	@ApiOperation(value = "Alteração de uma tarefa")
	public ResponseEntity<Void> update(@RequestBody final TaskUpdateDto dto) {
		service.update(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping
	@ApiOperation(value = "Marcar uma tarefa como concluída")
	public ResponseEntity<Void> taskDone(@RequestParam final Long id) {
		service.taskDone(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping
	@ApiOperation(value = "Exclusão de uma tarefa")
	public ResponseEntity<Void> delete(@RequestParam final Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
