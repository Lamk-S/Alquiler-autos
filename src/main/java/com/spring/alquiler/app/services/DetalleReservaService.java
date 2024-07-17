package com.spring.alquiler.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.alquiler.app.models.Automovil;
import com.spring.alquiler.app.models.DetalleReserva;
import com.spring.alquiler.app.models.Reserva;
import com.spring.alquiler.app.repository.AutomovilRepository;
import com.spring.alquiler.app.repository.DetalleReservaRepository;
import com.spring.alquiler.app.repository.ReservaRepository;

@Service
public class DetalleReservaService {
    private final DetalleReservaRepository detalleReservaRepository;
    private final ReservaRepository reservaRepository;
    private final AutomovilRepository automovilRepository;

    public DetalleReservaService(DetalleReservaRepository detalleReservaRepository, ReservaRepository reservaRepository,
            AutomovilRepository automovilRepository) {
        this.detalleReservaRepository = detalleReservaRepository;
        this.reservaRepository = reservaRepository;
        this.automovilRepository = automovilRepository;
    }

    public List<DetalleReserva> findAll() {
        return detalleReservaRepository.findAll();
    }

    public DetalleReserva findById(Long id) {
        return detalleReservaRepository.findById(id).orElseThrow(
            () -> new IllegalStateException("Detalle de reserva no encontrado con ID: " + id));
    }

    public DetalleReserva saveDetalle(DetalleReserva detalleReserva) {
        Long reservaId = detalleReserva.getReserva().getId();
        Long automovilId = detalleReserva.getAutomovil().getId();
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(
            () -> new IllegalArgumentException("La reserva con id " + reservaId + " no existe")
        );
        Automovil automovil = automovilRepository.findById(automovilId).orElseThrow(
            () -> new IllegalArgumentException("El automovil con id " + automovilId + " no existe")
        );
        detalleReserva.setReserva(reserva);
        detalleReserva.setAutomovil(automovil);
        return detalleReservaRepository.save(detalleReserva);
    }

    public void deleteById(Long id) {
        boolean existe = detalleReservaRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("Detalle de reserva no encontrado con ID: " + id);
        }
        detalleReservaRepository.deleteById(id);
    }

    public DetalleReserva update(Long id, DetalleReserva updatedDetalleReserva) {
        DetalleReserva detalleReservaActual = detalleReservaRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Detalle de reserva no encontrado con ID: " + id)
        );

        Long reservaId = updatedDetalleReserva.getReserva().getId();
        Long automovilId = updatedDetalleReserva.getAutomovil().getId();
        Reserva reserva = reservaRepository.findById(reservaId).orElseThrow(
            () -> new IllegalArgumentException("La reserva con id " + reservaId + " no existe")
        );
        Automovil automovil = automovilRepository.findById(automovilId).orElseThrow(
            () -> new IllegalArgumentException("El automovil con id " + automovilId + " no existe")
        );

        detalleReservaActual.setReserva(reserva);
        detalleReservaActual.setAutomovil(automovil);
        detalleReservaActual.setPrecioAlquiler(updatedDetalleReserva.getPrecioAlquiler());
        detalleReservaActual.setGalonesGasolina(updatedDetalleReserva.getGalonesGasolina());
        
        return detalleReservaRepository.save(detalleReservaActual);
    }
}
