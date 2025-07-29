package com.example.entities;

import com.example.enums.EstadoTurno;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int identificadorProgresivo;

    @Column(nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estadoTurno;

    @Column(nullable = false)
    private String descripcion;



    @ManyToOne
    @JoinColumn(name = "ciudadano_id", nullable = false)
    private Ciudadano ciudadano;

    public Turno() {
    }

    public Turno(int identificadorProgresivo, LocalDate fecha, EstadoTurno estadoTurno, Ciudadano ciudadano,String descripcion) {
        this.identificadorProgresivo = identificadorProgresivo;
        this.fecha = fecha;
        this.estadoTurno = estadoTurno;
        this.ciudadano = ciudadano;
        this.descripcion = descripcion;
    }

    public void setIdentificadorProgresivo(int identificadorProgresivo) {
        this.identificadorProgresivo = identificadorProgresivo;
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
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

