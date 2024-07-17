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

import com.spring.alquiler.app.models.DetalleReserva;
import com.spring.alquiler.app.services.DetalleReservaService;

@RestController
@RequestMapping("api/detalles")
public class DetalleReservaController {
    private final DetalleReservaService detalleReservaService;

    public DetalleReservaController(DetalleReservaService detalleReservaService) {
        this.detalleReservaService = detalleReservaService;
    }

    @GetMapping
    public List<DetalleReserva> getAllDetalles() {
        return detalleReservaService.findAll();
    }

    @GetMapping("/{id}")
    public DetalleReserva getDetalleById(@PathVariable Long id) {
        return detalleReservaService.findById(id);
    }

    @PostMapping
    public DetalleReserva saveDetalle(@RequestBody DetalleReserva detalleReserva) {
        return detalleReservaService.saveDetalle(detalleReserva);
    }

    @PutMapping("/{id}")
    public DetalleReserva updateDetalle(@PathVariable Long id, @RequestBody DetalleReserva detalleReserva) {
        return detalleReservaService.update(id, detalleReserva);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalle(@PathVariable Long id) {
        detalleReservaService.deleteById(id);
    }
}
