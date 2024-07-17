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

import com.spring.alquiler.app.models.Automovil;
import com.spring.alquiler.app.services.AutomovilService;

@RestController
@RequestMapping("api/automoviles")
public class AutomovilController {
    private final AutomovilService automovilService;

    public AutomovilController(AutomovilService automovilService) {
        this.automovilService = automovilService;
    }

    @GetMapping
    public List<Automovil> getAllAutomoviles() {
        return automovilService.findAll();
    }

    @GetMapping("/{id}")
    public Automovil getAutomovilById(@PathVariable Long id) {
        return automovilService.findById(id);
    }

    @PostMapping
    public Automovil saveAutomovil(@RequestBody Automovil automovil) {
        return automovilService.saveAutomovil(automovil);
    }

    @PutMapping("/{id}")
    public Automovil updateAutomovil(@PathVariable Long id, @RequestBody Automovil automovil) {
        return automovilService.update(id, automovil);
    }

    @DeleteMapping("/{id}")
    public void deleteAutomovil(@PathVariable Long id) {
        automovilService.deleteById(id);
    }
}
