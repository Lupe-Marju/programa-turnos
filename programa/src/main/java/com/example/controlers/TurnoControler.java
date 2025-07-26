package com.example.controlers;

import com.example.entities.Ciudadano;
import com.example.entities.Turno;
import com.example.enums.EstadoTurno;
import com.example.persistence.TurnoJPA;

import java.time.LocalDate;

public class TurnoControler {

TurnoJPA turnoJPA = new TurnoJPA();


    public void agregarTurno(EstadoTurno estadoTurno,LocalDate fecha, Long ciudadanoId){
        //crear un nuevo turno
        Turno turno = new Turno();
        //Aqui logica del metodo de crear el contador;
        //turno.setIdentificadorProgresivo( );
        turno.setEstadoTurno(estadoTurno);
        turno.setFecha(fecha);
        //Aqui esta mal porque nuestro constructor no tiene el ID, porque nos dijeron que nunca deberian tenerlo
        //sin embargo en el codigo que subio el profe lo tiene asi en su entidad
        // public Persona(Long id, String nombre, String apellido, Integer edad, String email) {
        //         this.id = id;
        //         this.nombre = nombre;
        //         this.apellido = apellido;
        //     } https://students.hackaboss.com/bootcamps/jvb02rt/curso-2-java-avanzado-y-buenas-practicas/-/blob/main/dias_practicos/repaso/fakebook/app/src/main/java/com/example/entities/Persona.java?ref_type=heads
        //y luego en su controlador lo agrega asi
        //nuevaTarjeta.setPersona(new Persona(idPersona, null, null,null,null));
        //https://students.hackaboss.com/bootcamps/jvb02rt/curso-2-java-avanzado-y-buenas-practicas/-/blob/main/dias_practicos/repaso/fakebook/app/src/main/java/com/example/controllers/TarjetaController.java?ref_type=heads
       // turno.setCiudadano(new Ciudadano(ciudadanoId, null,null,null));

        turnoJPA.agregarTurno(turno);
    }


}

