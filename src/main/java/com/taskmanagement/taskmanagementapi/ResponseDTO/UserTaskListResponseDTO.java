package com.taskmanagement.taskmanagementapi.ResponseDTO;

import com.taskmanagement.taskmanagementapi.Enum.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTaskListResponseDTO {
    private String title;
    private String description;
    private Date dueDate;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
