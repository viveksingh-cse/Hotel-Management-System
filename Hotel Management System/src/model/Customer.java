package model;

import java.time.LocalDateTime;

public class Customer {
    private int id;
    private String name;
    private int roomId;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    // other fields, constructors, getters, setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    // Optionally, add a setter if needed
    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name, int roomId, LocalDateTime checkIn) {
        this.name = name;
        this.roomId = roomId;
        this.checkIn = checkIn;
    }
}