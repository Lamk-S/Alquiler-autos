package com.spring.alquiler.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.alquiler.app.models.DetalleReserva;

public interface DetalleReservaRepository extends JpaRepository<DetalleReserva, Long> {

}
