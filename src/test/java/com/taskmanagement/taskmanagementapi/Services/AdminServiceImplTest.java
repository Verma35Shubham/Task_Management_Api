package com.taskmanagement.taskmanagementapi.Services;

import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import com.taskmanagement.taskmanagementapi.Repository.TaskManagementRepository;
import com.taskmanagement.taskmanagementapi.Services.ServiceImpl.AdminServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {

    @Mock
    private TaskManagementRepository taskManagementRepository;

    private AdminServiceImpl adminService;

    @BeforeEach
    void setUp(){
        this.adminService = new AdminServiceImpl(this.taskManagementRepository);
    }

    @Test
    void findAllTask() {
        adminService.findAllTask();
        verify(taskManagementRepository).findAll();
    }

    @Test
    void findAllTaskByStatus() {
        adminService.findAllTaskByStatus(TaskStatus.COMPLETED);
        verify(taskManagementRepository).findAllTaskByStatus(TaskStatus.COMPLETED);
    }
}