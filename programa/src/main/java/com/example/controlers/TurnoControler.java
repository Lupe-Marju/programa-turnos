package com.example.controlers;

import com.example.entities.Turno;
import com.example.enums.EstadoTurno;
import com.example.persistence.CiudadanoJPA;
import com.example.persistence.TurnoJPA;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TurnoControler {

    TurnoJPA turnoJPA = new TurnoJPA();
    CiudadanoJPA ciudadanoJPA = new CiudadanoJPA();
    private int contador = 1;

    public List<Turno> listarTodos() {
        return turnoJPA.listarTurnos();
    }

    public List<Turno> filtrarPorEstado(EstadoTurno estado) {
        return turnoJPA.listarTurnos()
                .stream()
                .filter(turno -> turno.getEstadoTurno() == estado)
                .collect(Collectors.toList());
    }

    public List<Turno> filtrarPorFecha(LocalDate fecha) {
        return turnoJPA.listarTurnos()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public void agregarTurno(EstadoTurno estadoTurno, LocalDate fecha, Long ciudadanoId) {
        // crear un nuevo turno
        Turno turno = new Turno();

        //Aqui logica del metodo de crear el contador;
        turno.setIdentificadorProgresivo(contador++);
        turno.setEstadoTurno(estadoTurno);
        turno.setFecha(fecha);
        turno.setCiudadano(ciudadanoJPA.buscarPorId(ciudadanoId));
        turnoJPA.agregarTurno(turno);
    }
}

