package com.example.lucampusfilterdata.service;


import com.example.lucampusfilterdata.model.Event;
import com.example.lucampusfilterdata.model.Room;

import java.util.List;

public interface FilterService {

    List<Room> findRoomsAtFloor(int i);

    String findAttendingEvents(String studentId, String eventName);

}
