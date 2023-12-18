package com.taskmanagement.taskmanagementapi.Services;

import com.taskmanagement.taskmanagementapi.Enum.Role;
import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import com.taskmanagement.taskmanagementapi.RequestDTO.UserRequestDTO;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementResponseDTO;

import java.util.List;

public interface AdminService {
    public List<TaskManagementResponseDTO> findAllTask();
    public List<TaskManagementResponseDTO> findAllTaskByStatus(TaskStatus taskStatus);

    public String addAdmin(UserRequestDTO userRequestDTO, Role role);
}
