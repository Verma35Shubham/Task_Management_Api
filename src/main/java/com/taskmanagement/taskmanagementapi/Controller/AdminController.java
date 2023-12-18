package com.taskmanagement.taskmanagementapi.Controller;

import com.taskmanagement.taskmanagementapi.Enum.Role;
import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import com.taskmanagement.taskmanagementapi.RequestDTO.UserRequestDTO;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementResponseDTO;
import com.taskmanagement.taskmanagementapi.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public String addAdmin(@RequestBody UserRequestDTO userRequestDTO){
        return adminService.addAdmin(userRequestDTO, Role.ROLE_Admin);
    }
    @GetMapping("/find/all/task")
    @PreAuthorize("hasRole('Admin')")
    public List<TaskManagementResponseDTO> findAllTask(){
        return adminService.findAllTask();
    }

    @GetMapping("/get/category/{taskStatus}")
    @PreAuthorize("hasRole('Admin')")
    public List<TaskManagementResponseDTO> getAllProductByCategory(@PathVariable("taskStatus")TaskStatus taskStatus){
        return adminService.findAllTaskByStatus(taskStatus);
    }
}
