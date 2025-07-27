package com.example.entities;

import com.example.enums.EstadoTurno;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turnos")
public class Turno {
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int identificadorProgresivo;
    /*Falta lógica para identificadorProgresivo
    El atributo identificadorProgresivo no se genera automáticamente.
    Necesitamos un contador o una consulta para obtener
    el máximo actual y sumarle 1.
    *
    * */

   /* @Column(nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estadoTurno;

    @ManyToOne
    @JoinColumn(name = "ciudadano_id",nullable = false)
    private Ciudadano ciudadano;

    /*@PrePersist
    public void asignarIdentificador() {
        this.identificadorProgresivo = contador++;
    }*/

    /*public Turno() {
    }

    public Turno(int identificadorProgresivo, LocalDate fecha, EstadoTurno estadoTurno, Ciudadano ciudadano) {
        this.identificadorProgresivo = identificadorProgresivo;
        this.fecha = fecha;
        this.estadoTurno = estadoTurno;
        this.ciudadano = ciudadano;
    }

    public Long getId() {
        return id;
    }

    public int getIdentificadorProgresivo() {
        return identificadorProgresivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public EstadoTurno getEstadoTurno() {
        return estadoTurno;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public void setEstadoTurno(EstadoTurno estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setIdentificadorProgresivo(int identificadorProgresivo) {this.identificadorProgresivo = identificadorProgresivo;}
}*/


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // Este identificador es progresivo y debe asignarse manualmente
        @Column(nullable = false)
        private int identificadorProgresivo;

        @Column(nullable = false)
        private LocalDate fecha;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private EstadoTurno estadoTurno;

        @ManyToOne(optional = false)
        @JoinColumn(name = "ciudadano_id")
        private Ciudadano ciudadano;

    public Turno() {
    }

    public Turno(int identificadorProgresivo, LocalDate fecha, EstadoTurno estadoTurno, Ciudadano ciudadano) {
        this.identificadorProgresivo = identificadorProgresivo;
        this.fecha = fecha;
        this.estadoTurno = estadoTurno;
        this.ciudadano = ciudadano;
    }

        // Getters
        public Long getId() {
        return id;
    }

        public int getIdentificadorProgresivo() {
        return identificadorProgresivo;
    }

        public LocalDate getFecha() {
        return fecha;
    }

        public EstadoTurno getEstadoTurno() {
        return estadoTurno;
    }

        public Ciudadano getCiudadano() {
        return ciudadano;
    }

        // Setters
        public void setIdentificadorProgresivo(int identificadorProgresivo) {
        this.identificadorProgresivo = identificadorProgresivo;
    }

        public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

        public void setEstadoTurno(EstadoTurno estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

        public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
}

