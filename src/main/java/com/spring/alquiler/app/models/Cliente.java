package com.spring.alquiler.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.Set;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> reservas;
}
