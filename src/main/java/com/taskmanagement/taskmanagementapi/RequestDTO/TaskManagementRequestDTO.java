package com.taskmanagement.taskmanagementapi.RequestDTO;


import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskManagementRequestDTO {
    private String email;
    private String title;
    private String description;
    private String dueDate;
    private TaskStatus status;
}
