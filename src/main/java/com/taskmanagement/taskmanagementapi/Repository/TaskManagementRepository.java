package com.taskmanagement.taskmanagementapi.Repository;

import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import com.taskmanagement.taskmanagementapi.Model.Task;
import com.taskmanagement.taskmanagementapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskManagementRepository extends JpaRepository<Task, Integer> {

    List<Task> findByUserId(int userId);
    List<Task> findAllTaskByStatus(TaskStatus taskStatus);
}
