package org.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "videojuegos")
public class Videojuego implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String titulo;

    @Column(name = "puntaje", nullable = true)
    private Integer puntaje;
    
    @Column(name="desarrolladora", nullable = false)
    private String desarrolladora;
    
    @OneToMany(mappedBy = "videojuego", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private List<Logro> logros;
    
    private List<VideojuegoJugador> jugadores;
    
//    @ManyToMany(mappedBy = "videojuegos")
//    private List<Jugador> jugadores;

    public Videojuego() {
    }

    public Videojuego(String titulo, Integer puntaje, String desarrolladora, List<Logro> logros) {
        this.titulo = titulo;
        this.puntaje = puntaje;
        this.desarrolladora = desarrolladora;
        this.logros = logros;
    }

    public Videojuego(String titulo, Integer puntaje, String desarrolladora) {
        this.titulo = titulo;
        this.puntaje = puntaje;
        this.desarrolladora = desarrolladora;
    }

    public Videojuego(Long id, String titulo, Integer puntaje, String desarrolladora, List<Logro> logros) {
        this.id = id;
        this.titulo = titulo;
        this.puntaje = puntaje;
        this.desarrolladora = desarrolladora;
        this.logros = logros;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public List<Logro> getLogros() {
        return logros;
    }

    public void setLogros(List<Logro> logros) {
        this.logros = logros;
    }

    public List<VideojuegoJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<VideojuegoJugador> jugadores) {
        this.jugadores = jugadores;
    }

//    public List<Jugador> getJugadores() {
//        return jugadores;
//    }
//
//    public void setJugadores(List<Jugador> jugadores) {
//        this.jugadores = jugadores;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videojuego)) {
            return false;
        }
        Videojuego other = (Videojuego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.dominio.Videojuego[ id=" + id + " ]";
    }
    
}
