package com.example.demo.controller;

import com.example.demo.model.Veterinarian;
import com.example.demo.repository.VeterinarianRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/veterinarians")
public class VeterinarianController {

    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianController(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    @GetMapping
    public String listVeterinarians(Model model) {
        model.addAttribute("veterinarians", veterinarianRepository.findAll());
        return "veterinarians";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("veterinarian", new Veterinarian());
        return "addVeterinarian";
    }

    @PostMapping("/add")
    public String addVeterinarian(Veterinarian veterinarian) {
        veterinarianRepository.save(veterinarian);
        return "redirect:/veterinarians";
    }

    @GetMapping("/edit/{id}")
    public String editVeterinarian(@PathVariable Long id, Model model) {
        model.addAttribute("veterinarian", veterinarianRepository.findById(id).orElseThrow());
        return "editVeterinarian";
    }

    @PostMapping("/update/{id}")
    public String updateVeterinarian(@PathVariable Long id, Veterinarian veterinarian) {
        veterinarian.setId(id);
        veterinarianRepository.save(veterinarian);
        return "redirect:/veterinarians";
    }
}
