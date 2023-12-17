package com.taskmanagement.taskmanagementapi.Services;

import com.taskmanagement.taskmanagementapi.Exceptions.InvalidPasswordException;
import com.taskmanagement.taskmanagementapi.Exceptions.WrongUserActionException;
import com.taskmanagement.taskmanagementapi.RequestDTO.UserRequestDTO;
import com.taskmanagement.taskmanagementapi.RequestDTO.UserTaskRequestDTO;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementListResponseDTO;

public interface UserService {
    public String addUser(UserRequestDTO userRequestDTO);
    public String loginUser(UserTaskRequestDTO userTaskRequestDTO) throws WrongUserActionException, InvalidPasswordException;
    public String logoutUser(String emailId) throws WrongUserActionException;

    public TaskManagementListResponseDTO getAllTasksforUser(String emailId) throws WrongUserActionException, InvalidPasswordException;
}
