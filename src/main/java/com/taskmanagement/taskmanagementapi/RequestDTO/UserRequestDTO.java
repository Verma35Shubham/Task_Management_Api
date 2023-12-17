package com.taskmanagement.taskmanagementapi.RequestDTO;

import com.taskmanagement.taskmanagementapi.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String userName;
    private String email;
    private String password;
    private Role role;
}
