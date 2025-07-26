package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.persistence.GenericoJPA;

import java.util.List;

public class CiudadanoController {

    private GenericoJPA<Ciudadano> ciudadanoJPA;

    public CiudadanoController() {
        this.ciudadanoJPA = new GenericoJPA<>(Ciudadano.class);
    }


    public void guardarCiudadano(Ciudadano ciudadano) {
        ciudadanoJPA.guardar(ciudadano);
    }


    public Ciudadano buscarPorId(Long id) {
        return ciudadanoJPA.buscarPorId(id);
    }


    public List<Ciudadano> listarTodos() {
        return ciudadanoJPA.listarTodos();
    }


    public Ciudadano buscarPorDni(String dni) {
        return ciudadanoJPA.getEntityManager()
                .createQuery("SELECT c FROM Ciudadano c WHERE c.dni = :dni", Ciudadano.class)
                .setParameter("dni", dni)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

}

