package com.example.fleet_user_management.repo;

import com.example.fleet_user_management.entity.Fleet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FleetRepository extends MongoRepository<Fleet, String> {

}
