package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "ciudadanos")
public class Ciudadano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String dni;

    public Ciudadano() {
    }

    public Ciudadano(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}
