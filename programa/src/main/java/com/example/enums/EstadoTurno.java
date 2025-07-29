package com.example.enums;

public enum EstadoTurno {
    EN_ESPERA("En espera"),
    YA_ATENDIDO("Ya atendido");

    private final String descripcion;

    EstadoTurno(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static EstadoTurno fromDescripcion(String descripcion) {
        if (descripcion == null) {
            return null;
        }
        for (EstadoTurno estado : EstadoTurno.values()) {
            if (estado.descripcion.equalsIgnoreCase(descripcion)) {
                return estado;
            }
        }
        // fallback: intentamos con el nombre del enum
        for (EstadoTurno estado : EstadoTurno.values()) {
            if (estado.name().equalsIgnoreCase(descripcion.replace(" ", "_"))) {
                return estado;
            }
        }
        return null;
    }
}

