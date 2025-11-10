package com.example.demo.controller;

import com.example.demo.model.Appointments;
import com.example.demo.model.Pet;
import com.example.demo.repository.AppointmentsRepository;
import com.example.demo.repository.PetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AppController {

    private final PetRepository petRepository;
    private final AppointmentsRepository appointmentsRepository;

    // Spring automatski ubacuje repozitorije kroz konstruktor
    public AppController(PetRepository petRepository, AppointmentsRepository appointmentsRepository) {
        this.petRepository = petRepository;
        this.appointmentsRepository = appointmentsRepository;
    }

    // Lista ljubimaca
    @GetMapping("/pets")
    public String listPets(Model model) {
        List<Pet> pets = petRepository.findAll(); // Dohvati sve iz baze
        model.addAttribute("pets", pets);
        return "listA";
    }

    // Lista termina (svi termini svih ljubimaca)
    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        List<Appointments> allAppointments = appointmentsRepository.findAll(); // Svi termini iz baze
        model.addAttribute("appointments", allAppointments);
        return "listB";
    }

    // Akcija – prikaz termina za određenog ljubimca
    @GetMapping("/pets/action/{id}")
    public String petAppointments(@PathVariable Long id, Model model) {
        Pet pet = petRepository.findById(id).orElse(null); // Dohvati iz baze po ID
        model.addAttribute("pet", pet);
        model.addAttribute("appointments", pet != null ? pet.getAppointments() : List.of());
        return "action";
    }
}
