package org.itson.pruebasjpa130;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.dominio.Direccion;
import org.dominio.Jugador;
import org.dominio.Logro;
import org.dominio.Sexo;
import org.dominio.Videojuego;

/**
 *
 * @author Oscar
 */
public class PruebasJPA130 {

    public static void main(String[] args) {
//        Videojuego videojuego = new Videojuego("Minecraft", 10, "Mojang");
//        Logro logro1 = new Logro("Ice Bucket Challenge", 100, videojuego);
//        Logro logro2 = new Logro("We need to go deeper", 200, videojuego);
//        videojuego.setLogros(Arrays.asList(logro1, logro2));
//
//        Jugador jugador = new Jugador(
//                "johnwick",
//                Sexo.HOMBRE,
//                new GregorianCalendar(2001, Calendar.MAY, 14),
//                new Direccion("Jose Vasconcelos", "2357", "Villa ITSON")
//        );

        
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.pruebasjpa130");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.persist(videojuego);
//        entityManager.persist(logro1);
//        entityManager.persist(logro2);
//        entityManager.persist(jugador);
        
        Jugador jugador = entityManager.find(Jugador.class, 1L);
        Videojuego juego1 = entityManager.find(Videojuego.class, 1L);
        Videojuego juego2 = entityManager.find(Videojuego.class, 2L);
        
        jugador.addVideojuego(juego1);
        jugador.addVideojuego(juego2);
        entityManager.persist(jugador);
        entityManager.getTransaction().commit();
    }
}
