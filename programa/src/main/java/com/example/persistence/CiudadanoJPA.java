package com.example.persistence;

import com.example.entities.Ciudadano;
import javax.persistence.EntityManager;

import java.util.List;

public class CiudadanoJPA {
    public void agregarCiudadano(Ciudadano ciudadano) {
        EntityManager em = ConfigJPA.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(ciudadano); // Guarda el turno
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    // Obtener listas por nombres de ciudadanos
    public List<Ciudadano> listarCiudadanos() {
         EntityManager em = ConfigJPA.getEntityManager();
         try {List<Ciudadano> ciudadanos = em.createQuery("SELECT t FROM Ciudadano t ORDER BY t.nombre", Ciudadano.class).getResultList();
            return ciudadanos;
         } finally {
                em.close();
         }
    }

    public Ciudadano buscarPorId(Long id){
        EntityManager em = ConfigJPA.getEntityManager();
        try {
            Ciudadano ciudadano = em.find(Ciudadano.class,id);
            return ciudadano;
        } finally {
            em.close();
        }
    }
}

