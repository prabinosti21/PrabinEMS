package com.diyo.Event.Management.System.EMS.controller;

import com.diyo.Event.Management.System.EMS.entity.User;
import com.diyo.Event.Management.System.EMS.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "API to register the user.")
    @PostMapping("/register")
    private ResponseEntity<String>registerUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @Operation(summary = "API to login into the EMS system.")
    @PostMapping("/login")
    private ResponseEntity<String>loginUser(@Valid @RequestBody User  user){
        return ResponseEntity.ok(userService.findByEmailAndPassword(user.getEmail(), user.getPassword()));
    }

    @Operation(summary = "API to get the information about the user registration.")
    @GetMapping()
    private ResponseEntity<List<User>>getUserInfo(){
        return ResponseEntity.ok(userService.getUserInfo());
    }

    @Operation(summary = "API to get the user by their respective ID.")
    @GetMapping("/info/{id}")
    private ResponseEntity<User>getUserInfoById(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserInfoById(id));
    }

    @Operation(summary = "API to delete the user from the data base.")
    @DeleteMapping("/{id}")
    private ResponseEntity<String>deleteUserInfo(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.deleteUserInfo(id));
    }

    @Operation(summary = "API to update the user information.")
    @PutMapping("/{id}")
    private ResponseEntity<String>updateUserInfo(@Valid @PathVariable("id") Long id, @Valid @RequestBody User user){
        return ResponseEntity.ok(userService.updateUserInfo(id,user));
    }

    @Operation(summary = "API to get the user from their email id & security question answer.")
    @GetMapping("/forget/{email}/{securityAnswer}")
    private ResponseEntity<String>findByEmailAndSecurityAnswer
            (@Valid @PathVariable("email") String email, @Valid @PathVariable("securityAnswer") String securityAnswer)
    {
        return  ResponseEntity.ok((userService.findByEmailAndSecurityAnswer(email, securityAnswer)));
    }

    @Operation(summary = "API to reset the password for the user.")
    @PostMapping("/reset")
    private ResponseEntity<String>updatePassword(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.updatePassword(user));
    }
}
