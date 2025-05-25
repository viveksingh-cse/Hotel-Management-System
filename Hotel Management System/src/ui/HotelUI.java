package ui;

import javax.swing.*;
import java.awt.*;
import dao.RoomDAO;
import model.Room;
import java.util.List;

public class HotelUI extends JFrame {
    public HotelUI() {
        setTitle("Hotel Management System");
        setSize(500, 400);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Hotel Room List", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll, BorderLayout.CENTER);

        RoomDAO dao = new RoomDAO();
        List<Room> rooms = dao.getAllRooms();
        for (Room room : rooms) {
            textArea.append("Room " + room.getRoomNumber() + " - Type: " + room.getType() + " - Available: " + room.isAvailable() + "\n");
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
