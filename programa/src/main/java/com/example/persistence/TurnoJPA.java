package com.example.persistence;

import com.example.entities.Turno;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TurnoJPA {

    // Metodo para agregar un nuevo turno
    public void agregarTurno(Turno turno) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(turno); // Guarda el turno
            em.getTransaction().commit();
        }
    }

    // Obtener todos los turnos ordenados por identificadorProgresivo
    public List<Turno> listarTurnos() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            List<Turno> turnos = em.createQuery("SELECT t FROM Turno t ORDER BY t.identificadorProgresivo", Turno.class).getResultList();
            return turnos;
        }
    }
}

