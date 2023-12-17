package com.taskmanagement.taskmanagementapi.ResponseDTO;

import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskManagementResponseDTO {
    private String userName;
    private String title;
    private String description;
    private Date dueDate;
    private TaskStatus status;
    private String message;
}
