package com.example.demo.controller;

import com.example.demo.model.Veterinarian;
import com.example.demo.repository.VeterinarianRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarians")
public classVeterinarianRestController {

    private final VeterinarianRepository veterinarianRepository;

    public VeterinarianRestController(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    @GetMapping
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    @PostMapping
    public Veterinarian addVeterinarian(@RequestBody Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }
}
