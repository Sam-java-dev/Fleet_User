package com.example.fleet_user_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String mobile;
    @NotBlank
    private String fleetId;
    @NotBlank
    private String role;

}
