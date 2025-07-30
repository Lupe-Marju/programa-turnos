package com.example.persistence;

import com.example.entities.Turno;
import javax.persistence.EntityManager;

import java.util.List;

public class TurnoJPA {

    // Metodo para agregar un nuevo turno
    public void agregarTurno(Turno turno) {
        EntityManager em = ConfigJPA.getEntityManager();
            try{
            em.getTransaction().begin();
            em.persist(turno); // Guarda el turno
            em.getTransaction().commit();
            } finally {
                em.close();
            }
    }

    // Obtener todos los turnos ordenados por identificadorProgresivo
    public List<Turno> listarTurnos() {
        EntityManager em = ConfigJPA.getEntityManager();
        try {
            return em.createQuery("SELECT t FROM Turno t ORDER BY t.identificadorProgresivo", Turno.class).getResultList();
        } finally {
            em.close();
        }
    }
//Esto asegura que el contador no se reinicie y siempre aumente según el último valor.
    public int obtenerMaxIdentificadorProgresivo() {
         EntityManager em = ConfigJPA.getEntityManager();
        try{
            Integer max = em.createQuery("SELECT MAX(t.identificadorProgresivo) FROM Turno t", Integer.class)
                    .getSingleResult();
            return max != null ? max : 0;
        } finally {
            em.close();
        }
    }

    public Turno buscarPorId(Long id){
        EntityManager em = ConfigJPA.getEntityManager();
        try {
            Turno turno = em.find(Turno.class,id);
            return turno;
        } finally {
            em.close();
        }
    }
    public  void modificarTurno(Turno turno) {
        EntityManager em = ConfigJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(turno);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

