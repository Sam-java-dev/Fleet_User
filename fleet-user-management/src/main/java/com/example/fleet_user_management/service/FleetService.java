package com.example.fleet_user_management.service;

import com.example.fleet_user_management.dto.FleetRequest;
import com.example.fleet_user_management.entity.Fleet;
import com.example.fleet_user_management.exception.ResourceNotFoundException;
import com.example.fleet_user_management.repo.FleetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleetService {

    private static final Logger logger =
            LoggerFactory.getLogger(FleetService.class);
    private final FleetRepository repository;

    public FleetService(FleetRepository repository) {
        this.repository = repository;
    }


    public Fleet createFleet(FleetRequest request) {

        logger.info("Creating fleet: {}", request.getFleetname());

        Fleet fleet = Fleet.builder()
                .fleetname(request.getFleetname())
                .city(request.getCity())
                .status(request.getStatus())
                .build();

        Fleet savedFleet = repository.save(fleet);

        logger.info("Fleet created successfully with id: {}",
                savedFleet.getId());

        return savedFleet;
    }

        public List<Fleet> getAllFleets() {
            return repository.findAll();
        }

    public Fleet getFleetById(String id) {

        logger.info("Fetching fleet with id: {}", id);

        return repository.findById(id)
                .orElseThrow(() -> {

                    logger.error(
                            "Fleet not found with id: {}",
                            id);

                    return new ResourceNotFoundException(
                            "Fleet not found with id: " + id);
                });
    }
        public Fleet DeleteFleetById(String id) {
            Fleet fleet = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Fleet not found with id: " + id));
            repository.delete(fleet);
            return fleet;
        }

}
