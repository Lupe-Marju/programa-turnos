package com.example.entities;
import jakarta.persistence.*;


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
    @OneToMany(mappedBy = "ciudadano", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno>turnos;

    public Ciudadano() {
    }

    public Ciudadano(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Long getId() { return id; }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
}
