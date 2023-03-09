package org.itson.pruebasjpa130;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.dominio.Direccion;
import org.dominio.Jugador;
import org.dominio.Sexo;
import org.dominio.Videojuego;
import org.dominio.VideojuegoJugador;

/**
 *
 * @author Oscar
 */
public class PruebasJPA130 {

    public static void main(String[] args) {
        Videojuego videojuego = new Videojuego("Minecraft", 10, "Mojang");
//        Logro logro1 = new Logro("Ice Bucket Challenge", 100, videojuego);
//        Logro logro2 = new Logro("We need to go deeper", 200, videojuego);
//        videojuego.setLogros(Arrays.asList(logro1, logro2));

        Jugador jugador = new Jugador(
                "johnwick",
                Sexo.HOMBRE,
                new GregorianCalendar(2001, Calendar.MAY, 14),
                new Direccion("Jose Vasconcelos", "2357", "Villa ITSON")
        );

        
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.pruebasjpa130");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
            
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Videojuego> criteria = builder.createQuery(Videojuego.class);
//        TypedQuery<Videojuego> query = entityManager.createQuery(criteria);
//        
//        List<Videojuego> juegos = query.getResultList();
//        
//        for (Videojuego v: juegos) {
//            System.out.println(v);
//        }

        Videojuego juego = entityManager.find(Videojuego.class, videojuego);
        Jugador jw = entityManager.find(Jugador.class, jugador);

        VideojuegoJugador relacion1 = new VideojuegoJugador(juego, jw, new GregorianCalendar());
        entityManager.persist(relacion1);
        
        entityManager.getTransaction().commit();
    }
}
