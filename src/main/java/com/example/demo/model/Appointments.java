package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;



@Entity
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;

    public Appointments() {}

    public Appointments(LocalDateTime dateTime, String description, Pet pet, Veterinarian veterinarian) {
        this.dateTime = dateTime;
        this.description = description;
        this.pet = pet;
        this.veterinarian = veterinarian;
    }

    // Getteri i setteri
    public Long getId() { return id; }
    public LocalDateTime getDateTime() { return dateTime; }
    public String getDescription() { return description; }
    public Pet getPet() { return pet; }
    public Veterinarian getVeterinarian() { return veterinarian; }

    public void setId(Long id) { this.id = id; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public void setDescription(String description) { this.description = description; }
    public void setPet(Pet pet) { this.pet = pet; }
    public void setVeterinarian(Veterinarian veterinarian) { this.veterinarian = veterinarian; }
}
