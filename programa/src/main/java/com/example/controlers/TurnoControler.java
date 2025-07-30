package com.example.controlers;

import com.example.entities.Turno;
import com.example.enums.EstadoTurno;
import com.example.persistence.CiudadanoJPA;
import com.example.persistence.TurnoJPA;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TurnoControler {

    private TurnoJPA turnoJPA = new TurnoJPA();
    private CiudadanoJPA ciudadanoJPA = new CiudadanoJPA();

    public List<Turno> listarTodos() {
        return turnoJPA.listarTurnos();
    }

    // Filtramos por estado
    public List<Turno> filtrarPorEstado(EstadoTurno estado) {
        return turnoJPA.listarTurnos()
                .stream()
                .filter(turno -> turno.getEstadoTurno() == estado)
                .collect(Collectors.toList());
    }

    // Filtramos por fecha
    public List<Turno> filtrarPorFecha(LocalDate fecha) {
        return turnoJPA.listarTurnos()
                .stream()
                .filter(turno -> turno.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public void agregarTurno(EstadoTurno estadoTurno, LocalDate fecha, Long ciudadanoId, String descripcion) {
        // Obtener el último identificador progresivo guardado en BD
        int maxId = turnoJPA.obtenerMaxIdentificadorProgresivo();

        // Crea un nuevo turno con identificador progresivo correcto (maxId + 1)
        Turno turno = new Turno();
        turno.setIdentificadorProgresivo(maxId + 1);
        turno.setEstadoTurno(estadoTurno);
        turno.setFecha(fecha);
        turno.setCiudadano(ciudadanoJPA.buscarPorId(ciudadanoId));
        turno.setDescripcion(descripcion);

        // Guardar el turno en la BD
        turnoJPA.agregarTurno(turno);
    }

    public Turno buscarPorId(Long id) {
        return turnoJPA.buscarPorId(id);
    }

    public void modificarTurno(Turno turno) {
        turnoJPA.modificarTurno(turno);
    }
}
