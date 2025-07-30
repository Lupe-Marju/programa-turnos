package com.example.controlers;

import com.example.entities.Ciudadano;
import com.example.persistence.CiudadanoJPA;


import java.util.List;

public class CiudadanoControler {

    private CiudadanoJPA ciudadanoJPA = new CiudadanoJPA();

    public void agregarCiudadano(Ciudadano ciudadano) {
        ciudadanoJPA.agregarCiudadano(ciudadano);
    }

    public List<Ciudadano> listarCiudadanos() {
        return ciudadanoJPA.listarCiudadanos();
    }
}