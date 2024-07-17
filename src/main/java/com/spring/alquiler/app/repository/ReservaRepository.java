package com.spring.alquiler.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.alquiler.app.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
