package com.example.persistence;

import com.example.entities.Ciudadano;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static com.example.persistence.ConfigJPA.emf;

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
    // Determinamos si existe en la BD
    public boolean dniExistente(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(c) FROM Ciudadano c WHERE c.dni = :dni", Long.class);
            query.setParameter("dni", dni);
            return query.getSingleResult() > 0;
        } finally {
            em.close();
        }
    }
}

