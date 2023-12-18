package com.taskmanagement.taskmanagementapi.Services.ServiceImpl;

import com.taskmanagement.taskmanagementapi.Enum.Role;
import com.taskmanagement.taskmanagementapi.Exceptions.InvalidPasswordException;
import com.taskmanagement.taskmanagementapi.Exceptions.WrongUserActionException;
import com.taskmanagement.taskmanagementapi.Model.Task;
import com.taskmanagement.taskmanagementapi.Model.User;
import com.taskmanagement.taskmanagementapi.Repository.UserRepository;
import com.taskmanagement.taskmanagementapi.RequestDTO.UserRequestDTO;
import com.taskmanagement.taskmanagementapi.RequestDTO.UserTaskRequestDTO;
import com.taskmanagement.taskmanagementapi.ResponseDTO.TaskManagementListResponseDTO;
import com.taskmanagement.taskmanagementapi.ResponseDTO.UserTaskListResponseDTO;
import com.taskmanagement.taskmanagementapi.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .userName(userRequestDTO.getUserName())
                .email(userRequestDTO.getEmail())
                .password(new BCryptPasswordEncoder().encode(userRequestDTO.getPassword()))
                .role(Role.ROLE_User)
                .login(false)
                .build();

        userRepository.save(user);
        return "Congratulations! "+ user.getUserName()+" you have successfully registered as a user!";
    }

    @Override
    public String loginUser(UserTaskRequestDTO userTaskRequestDTO) throws WrongUserActionException, InvalidPasswordException {
        User user;
        try{
            user = userRepository.findByEmail(userTaskRequestDTO.getEmail());
        }catch (Exception e){
            throw new WrongUserActionException("Invalid User!");
        }
        if(!user.getPassword().equals(userTaskRequestDTO.getPassword())){
            throw new InvalidPasswordException("Please enter your correct password !!");
        }
        user.setLogin(true);

        userRepository.save(user);

        return "Congratulations! "+ user.getUserName()+" you have successfully login.";
    }

    @Override
    public String logoutUser(String emailId) throws WrongUserActionException {
        User user;
        try{
            user = userRepository.findByEmail(emailId);
        }catch (Exception e){
            throw new WrongUserActionException("Invalid User!");
        }
        if(!user.isLogin()){
            throw new WrongUserActionException("Invalid action, please login first");
        }

        user.setLogin(false);

        userRepository.save(user);

        return "Logout, see you again";
    }
    @Override
    public TaskManagementListResponseDTO getAllTasksforUser(String emailId) throws WrongUserActionException {
        User user;
        try{
            user = userRepository.findByEmail(emailId);
        }catch (Exception e){
            throw new WrongUserActionException("Invalid User!");
        }
        if(!user.isLogin()){
            throw new WrongUserActionException("Please login first !!");
        }
        List<UserTaskListResponseDTO> userTaskListResponseDTOList = new ArrayList<>();
        for(Task task : user.getTaskList()){
            UserTaskListResponseDTO userTaskListResponseDTO = UserTaskListResponseDTO.builder()
                    .title(task.getTitle())
                    .description(task.getDescription())
                    .dueDate(task.getDueDate())
                    .status(task.getStatus())
                    .build();
            userTaskListResponseDTOList.add(userTaskListResponseDTO);
        }
        TaskManagementListResponseDTO taskManagementListResponseDTO = TaskManagementListResponseDTO.builder()
                .userName(user.getUserName())
                .taskList(userTaskListResponseDTOList)
                .build();
        return taskManagementListResponseDTO;
    }
}
