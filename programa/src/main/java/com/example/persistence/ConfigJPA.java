package com.example.persistence;
import javax.persistence.*;

public class ConfigJPA {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadDePersistencia");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }

}
