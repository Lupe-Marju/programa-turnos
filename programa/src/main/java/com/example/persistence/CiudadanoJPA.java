package com.example.persistence;

import com.example.entities.Ciudadano;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static org.hibernate.tool.hbm2ddl.SchemaExport.execute;

public class CiudadanoJPA {

    // Agregar un ciudadano
    public void agregarCiudadano(Ciudadano ciudadano) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(ciudadano); // Guarda el turno
            em.getTransaction().commit();
        }
    }

    // Listar todos los ciudadanos (ordenados por id o nombre según la query)
    public List<Ciudadano> listarCiudadanos() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            return em.createQuery("SELECT c FROM Ciudadano c ORDER BY c.id", Ciudadano.class)
                    .getResultList();
        }
    }

    // Listar ciudadanos ordenados por nombre
    public List<Ciudadano> listarOrdenadoPorNombre() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
        TypedQuery<Ciudadano> query = em.createQuery(
                "SELECT c FROM Ciudadano c ORDER BY c.nombre ASC",
                Ciudadano.class
        );
        return query.getResultList();
         }
    }


    // Buscar ciudadano por ID
    public Ciudadano buscarPorId(Long id){
        try (EntityManager em = ConfigJPA.getEntityManager()) {
          return em.find(Ciudadano.class, id);
        }
    }

    // Actualizar ciudadano
    public void actualizarCiudadano(Ciudadano ciudadano) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(ciudadano);
            em.getTransaction().commit();
        }
    }


    // Eliminar ciudadano por ID
    public void eliminarCiudadano(Long id) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            Ciudadano c = em.find(Ciudadano.class, id);
            if (c != null) {
                em.getTransaction().begin();
                em.remove(c);
                em.getTransaction().commit();
            }
        }
    }
}
