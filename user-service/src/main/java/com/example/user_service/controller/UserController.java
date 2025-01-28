package com.example.user_service.controller;

import com.example.user_service.dto.ResponseDTO;
import com.example.user_service.entity.User;
import com.example.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") Long userId){
        ResponseDTO responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }
}
