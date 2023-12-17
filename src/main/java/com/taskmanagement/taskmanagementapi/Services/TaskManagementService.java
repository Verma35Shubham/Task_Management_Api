package com.taskmanagement.taskmanagementapi.Services;

import com.taskmanagement.taskmanagementapi.Exceptions.InvalidPasswordException;
import com.taskmanagement.taskmanagementapi.Exceptions.InvalidTaskException;
import com.taskmanagement.taskmanagementapi.Exceptions.WrongUserActionException;
import com.taskmanagement.taskmanagementapi.RequestDTO.*;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementListResponseDTO;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementResponseDTO;

public interface TaskManagementService {
    public TaskManagementResponseDTO addTask(TaskManagementRequestDTO taskManagementRequestDTO) throws WrongUserActionException, InvalidPasswordException;

    public TaskManagementResponseDTO updateTask(TaskUpdateRequestDTO taskUpdateRequestDTO) throws InvalidTaskException, WrongUserActionException, InvalidPasswordException;
    public String deleteTask(UserTaskDeleteRequestDTO userTaskDeleteRequestDTO) throws WrongUserActionException, InvalidPasswordException, InvalidTaskException;
}
