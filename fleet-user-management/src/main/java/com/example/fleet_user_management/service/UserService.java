package com.example.fleet_user_management.service;

import com.example.fleet_user_management.dto.UserRequest;
import com.example.fleet_user_management.entity.User;
import com.example.fleet_user_management.repo.FleetRepository;
import com.example.fleet_user_management.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final FleetRepository fleetRepository;

    public UserService(UserRepository repository, FleetRepository fleetRepository) {
        this.fleetRepository = fleetRepository;
        this.repository = repository;
    }

    public User createUser(UserRequest request) {

        if (repository.existsByEmail(
                request.getEmail())) {

            throw new RuntimeException(
                    "Email already exists");
        }

        fleetRepository.findById(
                        request.getFleetId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Fleet not found"));

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .fleetId(request.getFleetId())
                .role(request.getRole())
                .build();

        return repository.save(user);
    }
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public List<User> getUsersByFleet(
            String fleetId) {

        return repository.findByFleetId(
                fleetId);
    }
}
