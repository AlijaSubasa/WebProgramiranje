package com.example.demo.controller;

import com.example.demo.data.DemoData;
import com.example.demo.model.Appointments;
import com.example.demo.model.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AppController {

    // Lista ljubimaca
    @GetMapping("/pets")
    public String listPets(Model model) {
        List<Pet> pets = DemoData.getPets();
        model.addAttribute("pets", pets);
        return "listA";
    }

    // Lista termina (svi termini svih ljubimaca)
    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        List<Pet> pets = DemoData.getPets();
        List<Appointments> allAppointments = pets.stream()
                .flatMap(p -> p.getAppointments().stream())
                .toList();
        model.addAttribute("appointments", allAppointments);
        return "listB";
    }

    // Akcija – prikaz termina za određenog ljubimca
    @GetMapping("/pets/action/{id}")
    public String petAppointments(@PathVariable int id, Model model) {
        Pet pet = DemoData.getPetById(id);
        model.addAttribute("pet", pet);
        model.addAttribute("appointments", pet != null ? pet.getAppointments() : List.of());
        return "action";
    }
}
