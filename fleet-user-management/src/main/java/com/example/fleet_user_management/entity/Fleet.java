package com.example.fleet_user_management.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fleet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fleet {

    @Id
    private String id;
    private String fleetname;
    private String city;
    private String status;
}
