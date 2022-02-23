package com.viceri.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viceri.api.models.entities.TaskEntity;
import com.viceri.api.models.enums.Priority;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

	List<TaskEntity> findByUserIdAndIsDoneFalse(final Long userId);

	List<TaskEntity> findByUserIdAndIsDoneFalseAndPriority(final Long userId, final Priority priority);
}
