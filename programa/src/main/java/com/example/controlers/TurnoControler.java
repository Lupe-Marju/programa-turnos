package com.example.controlers;

import com.example.entities.Ciudadano;
import com.example.entities.Turno;
import com.example.enums.EstadoTurno;
import com.example.persistence.CiudadanoJPA;
import com.example.persistence.TurnoJPA;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/*public class TurnoControler {

    TurnoJPA turnoJPA = new TurnoJPA();

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
        // Aqui logica del metodo de crear el contador;
        // turno.setIdentificadorProgresivo( );
        turno.setEstadoTurno(estadoTurno);
        turno.setFecha(fecha);
        // Aqui esta mal porque nuestro constructor no tiene el ID, porque nos dijeron que nunca deberian tenerlo
        // sin embargo en el codigo que subio el profe lo tiene asi en su entidad
        // public Persona(Long id, String nombre, String apellido, Integer edad, String email) {
        //         this.id = id;
        //         this.nombre = nombre;
        //         this.apellido = apellido;
        //     } https://students.hackaboss.com/bootcamps/jvb02rt/curso-2-java-avanzado-y-buenas-practicas/-/blob/main/dias_practicos/repaso/fakebook/app/src/main/java/com/example/entities/Persona.java?ref_type=heads
        // y luego en su controlador lo agrega asi
        // nuevaTarjeta.setPersona(new Persona(idPersona, null, null,null,null));
        // https://students.hackaboss.com/bootcamps/jvb02rt/curso-2-java-avanzado-y-buenas-practicas/-/blob/main/dias_practicos/repaso/fakebook/app/src/main/java/com/example/controllers/TarjetaController.java?ref_type=heads
        // turno.setCiudadano(new Ciudadano(ciudadanoId, null,null,null)); Esto requiere que Ciudadano tenga un constructor con ID,
        // lo cual no es una buena práctica en JPA, pero puedes crear un stub con solo el id para que JPA entienda la relación.
    }
}*/

public class TurnoControler {

    private TurnoJPA turnoJPA = new TurnoJPA();
    private CiudadanoJPA ciudadanoJPA = new CiudadanoJPA();

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

    public void agregarTurno(EstadoTurno estadoTurno, LocalDate fecha, Long ciudadanoId){
        Turno turno = new Turno();

        /*// Generar identificador progresivo
        int maxId = turnoJPA.listarTurnos().stream()
                .mapToInt(Turno::getIdentificadorProgresivo)
                .max()
                .orElse(0);
        turno.setIdentificadorProgresivo(maxId + 1);

        turno.setEstadoTurno(estadoTurno);
        turno.setFecha(fecha);

        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setId(ciudadanoId); // solo establecemos el ID
        turno.setCiudadano(ciudadano);

        turnoJPA.agregarTurno(turno);*/

        // Asignar un ID progresivo manual
        int nuevoId = turnoJPA.listarTurnos().size() + 1;
        turno.setIdentificadorProgresivo(nuevoId);

        turno.setEstadoTurno(estadoTurno);
        turno.setFecha(fecha);

        // Buscar ciudadano por ID
        Ciudadano ciudadano = ciudadanoJPA.buscarPorId(ciudadanoId);
        turno.setCiudadano(ciudadano);

        turnoJPA.agregarTurno(turno);

    }
}





