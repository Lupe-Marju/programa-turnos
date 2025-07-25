package com.example.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroTurno;
    private String descripcion;
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private com.example.enums.EstadoTurno estado;

    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getNumeroTurno() { return numeroTurno; }
    public void setNumeroTurno(int numeroTurno) { this.numeroTurno = numeroTurno; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public com.example.enums.EstadoTurno getEstado() { return estado; }
    public void setEstado(com.example.enums.EstadoTurno estado) { this.estado = estado; }

    public Ciudadano getCiudadano() { return ciudadano; }
    public void setCiudadano(Ciudadano ciudadano) { this.ciudadano = ciudadano; }
}
