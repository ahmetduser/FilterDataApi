package com.example.lucampusfilterdata.controller;

import com.example.lucampusfilterdata.model.Room;
import com.example.lucampusfilterdata.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/lucampus/filter")
public class FilterController {

    @Autowired
    private FilterService service;

    @GetMapping("filterRoomFloor/{id}")
    public List<Room> filterRoomFloor(@PathVariable("id") int id) {
        return service.findRoomsAtFloor(id);
    }

    @GetMapping("filterAttendingEvent/{eventName}/{studentId}")
    public String getAttendingEvents(@PathVariable("eventName") String eventName,
                                     @PathVariable("studentId") String studentId) {
        return service.findAttendingEvents(studentId, eventName);
    }


}
