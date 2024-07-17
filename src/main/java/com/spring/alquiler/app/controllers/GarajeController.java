package com.spring.alquiler.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.alquiler.app.models.Garaje;
import com.spring.alquiler.app.services.GarajeService;

@RestController
@RequestMapping("api/garajes")
public class GarajeController {
    private final GarajeService garajeService;

    public GarajeController(GarajeService garajeService) {
        this.garajeService = garajeService;
    }

    @GetMapping
    public List<Garaje> getAllGarajes() {
        return garajeService.findAll();
    }

    @GetMapping("/{id}")
    public Garaje getGarajeById(@PathVariable Long id) {
        return garajeService.findById(id);
    }

    @PostMapping
    public Garaje saveGaraje(@RequestBody Garaje garaje) {
        return garajeService.saveGaraje(garaje);
    }

    @PutMapping("/{id}")
    public Garaje updateGaraje(@PathVariable Long id, @RequestBody Garaje garaje) {
        return garajeService.update(id, garaje);
    }

    @DeleteMapping("/{id}")
    public void deleteGaraje(@PathVariable Long id) {
        garajeService.deleteById(id);
    }
}
