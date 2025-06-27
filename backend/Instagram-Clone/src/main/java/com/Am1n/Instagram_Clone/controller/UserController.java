package com.Am1n.Instagram_Clone.controller;

import com.Am1n.Instagram_Clone.dto.User.UserDTO;
import com.Am1n.Instagram_Clone.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.Am1n.Instagram_Clone.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    Get list of users (search / discover)
    @GetMapping("/")
    public String getUsers(){
        return "Users";
    }

//    Get user profile
    @GetMapping("/{username}")
    public String getUserProfile(@PathVariable String username){
        return "User Profile";
    }

//    Update user profile
    // todo: add @RequestBody UserDTO dto
    @PutMapping("/{username}")
    public String updateUser(@PathVariable String username){
        return "Update user";
    }

//    Delete user
    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username){
        return "delete user";
    }


    @GetMapping("/all")
    public Page<UserDTO> getAllUsers(
            @RequestParam(defaultValue = "0") int page) {
        return userService.getAllUsers(page);
    }

}
