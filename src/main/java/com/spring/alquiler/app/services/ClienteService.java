package com.spring.alquiler.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.alquiler.app.models.Cliente;
import com.spring.alquiler.app.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(
            () -> new IllegalStateException("Cliente no encontrado con ID: " + id));
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        boolean existe = clienteRepository.existsById(id);
        if (!existe) {
            throw new IllegalStateException("Cliente no encontrado con ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

    public Cliente update(Long id, Cliente updatedCliente) {
        Cliente clienteActual = clienteRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Cliente no encontrado con ID: " + id)
        );

        clienteActual.setCodigo(updatedCliente.getCodigo());
        clienteActual.setDni(updatedCliente.getDni());
        clienteActual.setNombre(updatedCliente.getNombre());
        clienteActual.setDireccion(updatedCliente.getDireccion());
        clienteActual.setTelefono(updatedCliente.getTelefono());
        
        return clienteRepository.save(clienteActual);
    }
}
