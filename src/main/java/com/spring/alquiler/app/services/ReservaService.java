package com.spring.alquiler.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.alquiler.app.models.Cliente;
import com.spring.alquiler.app.models.Reserva;
import com.spring.alquiler.app.repository.ClienteRepository;
import com.spring.alquiler.app.repository.ReservaRepository;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;

    public ReservaService(ReservaRepository reservaRepository, ClienteRepository clienteRepository) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva findById(Long id) {
        return reservaRepository.findById(id).orElseThrow(
            () -> new IllegalStateException("Reserva no encontrada con ID: " + id));
    }

    public Reserva saveReserva(Reserva reserva) {
        Long clienteId = reserva.getCliente().getId();
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
            () -> new IllegalArgumentException("El cliente con id " + clienteId + " no existe")
        );
        reserva.setCliente(cliente);
        return reservaRepository.save(reserva);
    }

    public void deleteById(Long id) {
        boolean existe = reservaRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("Reserva no encontrada con ID: " + id);
        }
        reservaRepository.deleteById(id);
    }

    public Reserva update(Long id, Reserva updatedReserva) {
        Reserva reservaActual = reservaRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Reserva no encontrada con ID: " + id)
        );

        Long clienteId = updatedReserva.getCliente().getId();
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
            () -> new IllegalArgumentException("El cliente con id " + clienteId + " no existe")
        );

        reservaActual.setCliente(cliente);
        reservaActual.setPrecioTotal(updatedReserva.getPrecioTotal());
        reservaActual.setEntregado(updatedReserva.isEntregado());
        reservaActual.setFechaInicio(updatedReserva.getFechaInicio());
        reservaActual.setFechaFinal(updatedReserva.getFechaFinal());
        
        return reservaRepository.save(reservaActual);
    }
}
