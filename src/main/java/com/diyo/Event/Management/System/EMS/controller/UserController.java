package com.diyo.Event.Management.System.EMS.controller;

import com.diyo.Event.Management.System.EMS.entity.User;
import com.diyo.Event.Management.System.EMS.service.UserService;
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

    @PostMapping("/register")
    private ResponseEntity<String>registerUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    private ResponseEntity<String>loginUser(@Valid @RequestBody User  user){
        return ResponseEntity.ok(userService.findByEmailAndPassword(user.getEmail(), user.getPassword()));
    }

    @GetMapping()
    private ResponseEntity<List<User>>getUserInfo(){
        return ResponseEntity.ok(userService.getUserInfo());
    }

    @GetMapping("/info/{id}")
    private ResponseEntity<User>getUserInfoById(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserInfoById(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String>deleteUserInfo(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.deleteUserInfo(id));
    }

    @PutMapping("/{id}")
    private ResponseEntity<String>updateUserInfo(@Valid @PathVariable("id") Long id, @Valid @RequestBody User user){
        return ResponseEntity.ok(userService.updateUserInfo(id,user));
    }

    @GetMapping("/forget/{email}/{securityAnswer}")
    private ResponseEntity<String>findByEmailAndSecurityAnswer
            (@Valid @PathVariable("email") String email, @Valid @PathVariable("securityAnswer") String securityAnswer)
    {
        return  ResponseEntity.ok((userService.findByEmailAndSecurityAnswer(email,securityAnswer)));
    }

    @PostMapping("/reset")
    private ResponseEntity<String>updatePassword(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.updatePassword(user));
    }
}
