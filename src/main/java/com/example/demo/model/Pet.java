package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String species;
    private int age;
    private String ownerName;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Appointments> appointments = new ArrayList<>();

    public Pet() {}

    public Pet(String name, String species, int age, String ownerName) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
    }

    public void addAppointment(Appointments appointment) {
        appointments.add(appointment);
        appointment.setPet(this);
    }

    // Getteri i setteri
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public String getOwnerName() { return ownerName; }
    public List<Appointments> getAppointments() { return appointments; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecies(String species) { this.species = species; }
    public void setAge(int age) { this.age = age; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
}
