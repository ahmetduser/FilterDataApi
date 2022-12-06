package com.example.lucampusfilterdata.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    private int id;
    private String roomNumber;
    private int capacity;
    private int floor;


}
