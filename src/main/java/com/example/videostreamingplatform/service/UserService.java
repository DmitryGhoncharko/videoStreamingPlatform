package com.example.videostreamingplatform.service;

import com.example.videostreamingplatform.entity.User;
import com.example.videostreamingplatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(String login, String password){
        if(login!=null && password!=null && !login.isEmpty() && !login.isBlank() && !password.isBlank() && !password.isEmpty()){
            if(!userRepository.existsByUserLogin(login) && !login.equals("adminLogin")){
                User user = new User();
                user.setUserLogin(login);
                user.setUserPassword(password);
               return userRepository.save(user);
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean loginUser(String login, String password){
        if(login!=null && password!=null && !login.isEmpty() && !login.isBlank() && !password.isBlank() && !password.isEmpty()){
            if(userRepository.existsByUserLogin(login)){
                Optional<User> userOptional = userRepository.findUserByUserLogin(login);
                if(userOptional.isPresent()){
                    User user = userOptional.get();
                    return user.getUserLogin().equals(login) && user.getUserPassword().equals(password);
                }
            }
        }
        return false;
    }
}
