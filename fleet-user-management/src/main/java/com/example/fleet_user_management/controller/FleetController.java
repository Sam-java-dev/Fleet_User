package com.example.fleet_user_management.controller;

import com.example.fleet_user_management.dto.FleetRequest;
import com.example.fleet_user_management.entity.Fleet;
import com.example.fleet_user_management.service.FleetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fleet")
@RequiredArgsConstructor
public class FleetController {
    private final FleetService fleetService;

    @PostMapping
    public Fleet createFleet(@Valid @RequestBody FleetRequest request) {
        return fleetService.createFleet(request);
    }

    @GetMapping("/{id}")
    public Fleet getFleetById(@PathVariable String id) {
        return fleetService.getFleetById(id);
    }

    @GetMapping
    public List<Fleet> getAllFleets() {
        return fleetService.getAllFleets();
    }

    @DeleteMapping
    public Fleet deleteFleetById(@RequestParam String id) {
        return fleetService.DeleteFleetById(id);
    }


}
