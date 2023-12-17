package com.taskmanagement.taskmanagementapi.Config;

import com.taskmanagement.taskmanagementapi.Model.User;
import com.taskmanagement.taskmanagementapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("Could not found user !!");
        }
       OurUserInfoDetails ourUserInfoDetails = new OurUserInfoDetails(user);
        return ourUserInfoDetails;
    }
}
