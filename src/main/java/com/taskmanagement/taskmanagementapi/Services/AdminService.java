package com.taskmanagement.taskmanagementapi.Services;

import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import com.taskmanagement.taskmanagementapi.Model.Task;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementResponseDTO;

import java.util.List;

public interface AdminService {
    public List<TaskManagementResponseDTO> findAllTask();
    public List<TaskManagementResponseDTO> findAllTaskByStatus(TaskStatus taskStatus);
}
