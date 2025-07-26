package com.example.controllers;

import com.example.entities.Turno;
import com.example.enums.EstadoTurno;
import com.example.persistence.GenericoJPA;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TurnoController {

    private GenericoJPA<Turno> turnoJPA;

    public TurnoController() {
        this.turnoJPA = new GenericoJPA<>(Turno.class);
    }


    public void guardarTurno(Turno turno) {
        turnoJPA.guardar(turno);
    }


    public Turno buscarPorId(Long id) {
        return turnoJPA.buscarPorId(id);
    }


    public List<Turno> listarTodosOrdenados() {
        return turnoJPA.listarTodos()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t1.getIdentificadorProgresivo(), t2.getIdentificadorProgresivo()))
                .collect(Collectors.toList());
    }


    public List<Turno> filtrarPorEstado(EstadoTurno estado) {
        return turnoJPA.listarTodos()
                .stream()
                .filter(turno -> turno.getEstadoTurno() == estado)
                .collect(Collectors.toList());
    }


    public List<Turno> filtrarPorFecha(LocalDate fecha) {
        return turnoJPA.listarTodos()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
}

