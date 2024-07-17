package com.spring.alquiler.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.alquiler.app.models.Garaje;
import com.spring.alquiler.app.repository.GarajeRepository;

@Service
public class GarajeService {
    private final GarajeRepository garajeRepository;

    public GarajeService(GarajeRepository garajeRepository) {
        this.garajeRepository = garajeRepository;
    }

    public List<Garaje> findAll() {
        return garajeRepository.findAll();
    }

    public Garaje findById(Long id) {
        return garajeRepository.findById(id).orElseThrow(
            () -> new IllegalStateException("Garaje no encontrado con ID: " + id));
    }

    public Garaje saveGaraje(Garaje garaje) {
        return garajeRepository.save(garaje);
    }

    public void deleteById(Long id) {
        boolean existe = garajeRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("Garaje no encontrado con ID: " + id);
        }
        garajeRepository.deleteById(id);
    }

    public Garaje update(Long id, Garaje updatedGaraje) {
        Garaje garajeActual = garajeRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Garaje no encontrado con ID: " + id)
        );

        garajeActual.setDireccion(updatedGaraje.getDireccion());
        
        return garajeRepository.save(garajeActual);
    }
}
