package com.spring.alquiler.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.Set;

@Entity
@Data
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private String modelo;
    private String color;
    private String marca;

    @ManyToOne
    @JoinColumn(name = "garaje_id")
    private Garaje garaje;

    @OneToMany(mappedBy = "automovil")
    private Set<DetalleReserva> detalles;
}
