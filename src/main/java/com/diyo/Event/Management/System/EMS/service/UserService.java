package com.diyo.Event.Management.System.EMS.service;

import com.diyo.Event.Management.System.EMS.entity.User;
import com.diyo.Event.Management.System.EMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        userRepository.save(user);
        return "User registered successfully";
    }

    public String findByEmailAndPassword(String email, String password) {
        Optional<User>userFromDataBase = this.userRepository.findByEmailAndPassword(email,password);
        if ((userFromDataBase.isPresent())){
            return "Login Success";
        }
        else {
            return "Invalid email or password";
        }
    }

    public List<User> getUserInfo() {
        return userRepository.findAll();
    }

    public User getUserInfoById(Long id) {
        Optional<User>userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        else {
            return null;
        }
    }

    public String deleteUserInfo(Long id) {
        Optional<User>optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        else {
            return "User not found";
        }
    }

    public String updateUserInfo(Long id, User user) {
        Optional<User>optional = userRepository.findById(id);
        if(optional.isPresent()){
            User userFromDb = optional.get();
            user.setUserId(userFromDb.getUserId());
            userRepository.save(user);
            return "User information updated successfully";
        }
        else{
            return "User not found";
        }
    }

    public String findByEmailAndSecurityAnswer(String email, String securityAnswer) {
        Optional<User>userOptional = userRepository.findByEmailAndSecurityAnswer(email,securityAnswer);
        if(userOptional.isPresent()){
            return "User found successfully.";
        }
        else{
            return "User not found";
        }
    }
    public String updatePassword(User user) {
        Optional<User>userOptional = userRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent()){
            User userDb = userOptional.get();
            user.setUserId(userDb.getUserId());
            userRepository.save(user);
            return "Password changed successfully";
        }
        else{
            return "Password reset failed";
        }
    }
}
