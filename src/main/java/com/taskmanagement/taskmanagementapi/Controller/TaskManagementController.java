package com.taskmanagement.taskmanagementapi.Controller;

import com.taskmanagement.taskmanagementapi.Exceptions.InvalidTaskException;
import com.taskmanagement.taskmanagementapi.Exceptions.WrongUserActionException;
import com.taskmanagement.taskmanagementapi.RequestDTO.TaskManagementRequestDTO;
import com.taskmanagement.taskmanagementapi.RequestDTO.TaskUpdateRequestDTO;
import com.taskmanagement.taskmanagementapi.RequestDTO.UserTaskDeleteRequestDTO;
import com.taskmanagement.taskmanagementapi.RequestDTO.UserTaskRequestDTO;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementListResponseDTO;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementResponseDTO;
import com.taskmanagement.taskmanagementapi.Services.TaskManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskManagementController {
    @Autowired
    private TaskManagementService taskManagementService;


    @PostMapping("/add")
    public ResponseEntity addTask(@RequestBody TaskManagementRequestDTO taskManagementRequestDTO){
        TaskManagementResponseDTO taskManagementResponseDTO;
        try{
            taskManagementResponseDTO = taskManagementService.addTask(taskManagementRequestDTO);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(taskManagementResponseDTO, HttpStatus.ACCEPTED);
    }


    @PutMapping("/update/user_task")
    public ResponseEntity updateTask(@RequestBody TaskUpdateRequestDTO taskUpdateRequestDTO) throws InvalidTaskException, WrongUserActionException {
        TaskManagementResponseDTO taskManagementResponseDTO;
        try{
            taskManagementResponseDTO = taskManagementService.updateTask(taskUpdateRequestDTO);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(taskManagementResponseDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/user_task")
    public String deleteTask(@RequestBody UserTaskDeleteRequestDTO userTaskDeleteRequestDTO) throws WrongUserActionException, InvalidTaskException{
        String response = "";
        try {
            response = taskManagementService.deleteTask(userTaskDeleteRequestDTO);
        }catch (Exception e){
            return e.getMessage();
        }
        return response;
    }
}
