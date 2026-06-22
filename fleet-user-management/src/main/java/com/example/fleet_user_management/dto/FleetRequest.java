package com.example.fleet_user_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FleetRequest {
    @NotBlank
    private String fleetname;
    @NotBlank
    private String city;
    @NotBlank
    private String status;

}
