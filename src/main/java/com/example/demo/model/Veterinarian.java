package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;

    @OneToMany(mappedBy = "veterinarian", cascade = CascadeType.ALL)
    private List<Appointments> appointments;

    public Veterinarian() {}

    public Veterinarian(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Getteri i setteri
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public List<Appointments> getAppointments() { return appointments; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setAppointments(List<Appointments> appointments) { this.appointments = appointments; }
}
