package com.example.lucampusfilterdata.repository;

import com.example.lucampusfilterdata.model.Room;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FilterRepository {
    private Connection con = null;
    @Value("${spring.datasource.url}")
    String dbUrl;
    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;


    private Connection getDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        return con;
    }

    public List<Room> findRoomsAtFloor(int i) {
        List<Room> result = new ArrayList<>();

        Room room;
        String filterRooms = "SELECT * FROM room WHERE floor = " + i;

        try {
            Statement stm = getDBConnection().createStatement();
            ResultSet rs = stm.executeQuery(filterRooms);

            while (rs.next()) {
                room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getString("roomNumber"));
                room.setCapacity(rs.getInt("capacity"));
                room.setFloor(rs.getInt("floor"));
                result.add(room);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;

    }

    public String findAttendingEvents(String studentId, String eventName) {
        String res = "false";

        String result = "SELECT * FROM attending " + "WHERE attending.studentId = " + "'" + studentId + "'"
                + " AND attending.eventName = " + "'" + eventName + "'";

        try {
            Statement stm = getDBConnection().createStatement();
            ResultSet rs = stm.executeQuery(result);

            if (rs.next()) {
                res = "true";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }


}

