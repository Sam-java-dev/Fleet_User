package com.example.fleet_user_management.controller;

import com.example.fleet_user_management.dto.UserRequest;
import com.example.fleet_user_management.entity.User;
import com.example.fleet_user_management.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@Valid @RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{fleetId}")
    public List<User> getUsersByFleet(@PathVariable String fleetId) {
        return userService.getUsersByFleet(fleetId);
    }


}
