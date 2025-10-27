package com.example.demo.data;

import com.example.demo.model.Appointments;
import com.example.demo.model.Pet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DemoData {
    private static List<Pet> pets = new ArrayList<>();

    static {
        Pet p1 = new Pet(1, "Rex", "Pas", 5, "Alija");
        p1.addAppointment(new Appointments(1, LocalDateTime.of(2025, 10, 30, 10, 0), "Vakcinacija"));
        p1.addAppointment(new Appointments(2, LocalDateTime.of(2025, 11, 3, 15, 30), "Kontrola"));

        Pet p2 = new Pet(2, "Maza", "Mačka", 3, "Edna");
        p2.addAppointment(new Appointments(3, LocalDateTime.of(2025, 11, 1, 9, 0), "Čišćenje zuba"));

        pets.add(p1);
        pets.add(p2);
    }

    public static List<Pet> getPets() {
        return pets;
    }

    public static Pet getPetById(int id) {
        return pets.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
