package com.example.fleet_user_management.repo;

import com.example.fleet_user_management.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByFleetId(String fleetId);

    boolean existsByEmail(String email);
}
