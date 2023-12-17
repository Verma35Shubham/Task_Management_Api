package com.taskmanagement.taskmanagementapi.Services.ServiceImpl;

import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import com.taskmanagement.taskmanagementapi.Model.Task;
import com.taskmanagement.taskmanagementapi.Repository.TaskManagementRepository;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementResponseDTO;
import com.taskmanagement.taskmanagementapi.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private TaskManagementRepository taskManagementRepository;

    @Override
    public List<TaskManagementResponseDTO> findAllTask() {
        List<Task> taskList = taskManagementRepository.findAll();
        List<TaskManagementResponseDTO> taskManagementResponseDTOS = new ArrayList<>();

        for(Task task : taskList){
            TaskManagementResponseDTO managementResponseDTO = TaskManagementResponseDTO.builder()
                    .userName(task.getUser().getUserName())
                    .title(task.getTitle())
                    .description(task.getDescription())
                    .dueDate(task.getDueDate())
                    .status(task.getStatus())
                    .build();
            taskManagementResponseDTOS.add(managementResponseDTO);
        }
        return taskManagementResponseDTOS;
    }

    @Override
    public List<TaskManagementResponseDTO> findAllTaskByStatus(TaskStatus taskStatus) {
        List<Task> taskList = taskManagementRepository.findAllTaskByStatus(taskStatus);

        List<TaskManagementResponseDTO> taskManagementResponseDTOS = new ArrayList<>();

        for(Task task : taskList){
            TaskManagementResponseDTO managementResponseDTO = TaskManagementResponseDTO.builder()
                    .userName(task.getUser().getUserName())
                    .title(task.getTitle())
                    .description(task.getDescription())
                    .dueDate(task.getDueDate())
                    .status(task.getStatus())
                    .build();
            taskManagementResponseDTOS.add(managementResponseDTO);
        }
        return taskManagementResponseDTOS;
    }
}
