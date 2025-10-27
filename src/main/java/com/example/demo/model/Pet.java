package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private int id;
    private String name;
    private String species;
    private int age;
    private String ownerName;
    private List<Appointments> appointments = new ArrayList<>();

    public Pet(int id, String name, String species, int age, String ownerName) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
    }

    // Getteri i setteri
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public String getOwnerName() { return ownerName; }

    public List<Appointments> getAppointments() { return appointments; }

    public void addAppointment(Appointments appointment) {
        appointments.add(appointment);
    }
}
