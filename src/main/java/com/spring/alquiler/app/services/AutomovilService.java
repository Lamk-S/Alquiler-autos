package com.spring.alquiler.app.services;

import com.spring.alquiler.app.models.Automovil;
import com.spring.alquiler.app.models.Garaje;
import com.spring.alquiler.app.repository.AutomovilRepository;
import com.spring.alquiler.app.repository.GarajeRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AutomovilService {
    private final AutomovilRepository automovilRepository;
    private final GarajeRepository garajeRepository;

    public AutomovilService(AutomovilRepository automovilRepository, GarajeRepository garajeRepository) {
        this.automovilRepository = automovilRepository;
        this.garajeRepository = garajeRepository;
    }

    public List<Automovil> findAll() {
        return automovilRepository.findAll();
    }

    public Automovil findById(Long id) {
        return automovilRepository.findById(id).orElseThrow(
            () -> new IllegalStateException("Automovil no encontrado con ID: " + id));
    }

    public Automovil saveAutomovil(Automovil automovil) {
        Long garajeId = automovil.getGaraje().getId();
        Garaje garaje = garajeRepository.findById(garajeId).orElseThrow(
            () -> new IllegalArgumentException("El garaje con id " + garajeId + " no existe")
        );
        automovil.setGaraje(garaje);
        return automovilRepository.save(automovil);
    }

    public void deleteById(Long id) {
        boolean existe = automovilRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("Automovil no encontrado con ID: " + id);
        }
        automovilRepository.deleteById(id);
    }

    public Automovil update(Long id, Automovil updatedAutomovil) {
        Automovil automovilActual = automovilRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Automovil no encontrado con ID: " + id)
        );

        Long garajeId = updatedAutomovil.getGaraje().getId();
        Garaje garaje = garajeRepository.findById(garajeId).orElseThrow(
            () -> new IllegalArgumentException("El garaje con id " + garajeId + " no existe")
        );

        automovilActual.setGaraje(garaje);
        automovilActual.setMatricula(updatedAutomovil.getMatricula());
        automovilActual.setModelo(updatedAutomovil.getModelo());
        automovilActual.setColor(updatedAutomovil.getColor());
        automovilActual.setMarca(updatedAutomovil.getMarca());
        
        return automovilRepository.save(automovilActual);
    }
}
