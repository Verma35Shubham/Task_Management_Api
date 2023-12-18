package com.taskmanagement.taskmanagementapi.Repository;

import com.taskmanagement.taskmanagementapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
   User findByEmail(String email);
}
