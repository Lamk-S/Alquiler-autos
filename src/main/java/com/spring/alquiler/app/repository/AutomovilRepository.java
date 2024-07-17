package com.spring.alquiler.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.alquiler.app.models.Automovil;

public interface AutomovilRepository extends JpaRepository<Automovil, Long> {

}
