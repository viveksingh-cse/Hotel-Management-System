package dao;

import db.DBConnection;
import model.Customer;

import java.sql.*;

public class CustomerDAO {

    public void checkInCustomer(Customer customer) {
        try {
            Connection conn = DBConnection.getConnection();

            // Insert customer
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO customers(name, room_id, check_in) VALUES (?, ?, ?)"
            );
            ps.setString(1, customer.getName());
            ps.setInt(2, customer.getRoomId());
            ps.setTimestamp(3, Timestamp.valueOf(customer.getCheckIn()));
            ps.executeUpdate();

            // Update room availability
            PreparedStatement updateRoom = conn.prepareStatement("UPDATE rooms SET is_available = false WHERE id = ?");
            updateRoom.setInt(1, customer.getRoomId());
            updateRoom.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkOutCustomer(int roomId) {
        try {
            Connection conn = DBConnection.getConnection();

            // Update check-out time
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE customers SET check_out = NOW() WHERE room_id = ? AND check_out IS NULL"
            );
            ps.setInt(1, roomId);
            ps.executeUpdate();

            // Mark room available
            PreparedStatement updateRoom = conn.prepareStatement("UPDATE rooms SET is_available = true WHERE id = ?");
            updateRoom.setInt(1, roomId);
            updateRoom.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
