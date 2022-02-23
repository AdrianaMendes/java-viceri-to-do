package com.viceri.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.viceri.api.models.entities.TaskEntity;
import com.viceri.api.models.enums.Priority;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

	@Query(value = "SELECT * FROM task WHERE id = :id AND user_id = :userId", nativeQuery = true)
	Optional<TaskEntity> findByIdAndUserId(final Long id, final Long userId);
	
	List<TaskEntity> findByUserIdAndIsDoneFalse(final Long userId);

	List<TaskEntity> findByUserIdAndIsDoneFalseAndPriority(final Long userId, final Priority priority);
}
