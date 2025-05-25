package dao;

import db.DBConnection;
import model.Room;
import java.sql.*;
import java.util.*;

public class RoomDAO {
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM rooms");

            while (rs.next()) {
                rooms.add(new Room(
                    rs.getInt("id"),
                    rs.getString("room_number"),
                    rs.getString("type"),
                    rs.getBoolean("is_available")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
