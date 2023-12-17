package com.taskmanagement.taskmanagementapi.RequestDTO;

import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateRequestDTO {
    private String email;
    private int taskId;
    private String title;
    private String description;
    private Date dueDate;
    private TaskStatus status;
}
