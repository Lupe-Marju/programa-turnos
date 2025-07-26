package com.example.persistence;

import com.example.entities.Ciudadano;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CiudadanoJPA {
    public void agregarCiudadano(Ciudadano ciudadano) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(ciudadano); // Guarda el turno
            em.getTransaction().commit();
        }
    }

    // Obtener listas por nombres de ciudadanos
    public List<Ciudadano> listarCiudadanos() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            List<Ciudadano> ciudadanos = em.createQuery("SELECT t FROM Ciudadano t ORDER BY t.nombre", Ciudadano.class).getResultList();
            return ciudadanos;
        }
    }
}

