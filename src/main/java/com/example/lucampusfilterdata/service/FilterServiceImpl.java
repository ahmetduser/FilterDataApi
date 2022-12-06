package com.example.lucampusfilterdata.service;

import com.example.lucampusfilterdata.model.Event;
import com.example.lucampusfilterdata.model.Room;
import com.example.lucampusfilterdata.repository.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterRepository repo;

    @Override
    public List<Room> findRoomsAtFloor(int i) {
        return repo.findRoomsAtFloor(i);
    }

    @Override
    public String findAttendingEvents(String studentId, String eventName) {
        return repo.findAttendingEvents(studentId, eventName);
    }
}
