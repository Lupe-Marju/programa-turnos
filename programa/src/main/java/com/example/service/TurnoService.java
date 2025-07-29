package com.example.service;

import com.example.enums.EstadoTurno;

public class TurnoService {

    // Método para obtener el EstadoTurno desde la descripción
    public EstadoTurno obtenerEstadoPorDescripcion(String descripcion) {
        return EstadoTurno.fromDescripcion(descripcion);
    }
}
