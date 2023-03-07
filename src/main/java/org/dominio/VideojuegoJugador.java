package org.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "videojuegos_jugadores")
public class VideojuegoJugador implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name = "id_videojuego", nullable = false)
    private Videojuego videojuego;
    
    @ManyToOne()
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;
    
    @Column(name = "fecha_compra", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaCompra;

    public VideojuegoJugador() {
    }

    public VideojuegoJugador(Videojuego videojuego, Jugador jugador, Calendar fechaCompra) {
        this.videojuego = videojuego;
        this.jugador = jugador;
        this.fechaCompra = fechaCompra;
    }

    public VideojuegoJugador(Long id, Videojuego videojuego, Jugador jugador, Calendar fechaCompra) {
        this.id = id;
        this.videojuego = videojuego;
        this.jugador = jugador;
        this.fechaCompra = fechaCompra;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Calendar fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VideojuegoJugador)) {
            return false;
        }
        VideojuegoJugador other = (VideojuegoJugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.dominio.VideojuegoJugador[ id=" + id + " ]";
    }
    
}
