package com.example.demo.model;

import java.time.LocalDateTime;

public class Appointments {
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public Appointments(int id, LocalDateTime dateTime, String description) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
