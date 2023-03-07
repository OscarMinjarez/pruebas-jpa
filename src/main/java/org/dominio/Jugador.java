package org.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "pseudonimo", unique = true, nullable = false, length = 20)
    private String pseudonimo;
    
    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    @JoinColumn(name = "idDireccion", nullable = false)
    private Direccion direccion;
    
    @OneToMany(mappedBy = "jugador")
    private List<VideojuegoJugador> jugadoresDuenios;
    
//    @ManyToMany()
//    @JoinTable(
//            name = "videojuegosJugadores",
//            joinColumns = @JoinColumn(name = "idJugador"),
//            inverseJoinColumns = @JoinColumn(name = "idVideojuego")
//    )
//    private List<Videojuego> videojuegos;

    public Jugador() {
    }

    public Jugador(String pseudonimo, Sexo sexo, Calendar fechaNacimiento) {
        this.pseudonimo = pseudonimo;
        this.sexo = sexo;
        // this.fechaNacimiento = fechaNacimiento;
    }

    public Jugador(Long id, String pseudonimo, Sexo sexo, Calendar fechaNacimiento) {
        this.id = id;
        this.pseudonimo = pseudonimo;
        this.sexo = sexo;
        // this.fechaNacimiento = fechaNacimiento;
    }

    public Jugador(String pseudonimo, Sexo sexo, Calendar fechaNacimiento, Direccion direccion) {
        this.pseudonimo = pseudonimo;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        // this.direccion = direccion;
    }

    public Jugador(Long id, String pseudonimo, Sexo sexo, Calendar fechaNacimiento, Direccion direccion) {
        this.id = id;
        this.pseudonimo = pseudonimo;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        // this.fechaNacimiento = fechaNacimiento;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<VideojuegoJugador> getJugadoresDuenios() {
        return jugadoresDuenios;
    }

    public void setJugadoresDuenios(List<VideojuegoJugador> jugadoresDuenios) {
        this.jugadoresDuenios = jugadoresDuenios;
    }
    
    public void addJuegoComprado(VideojuegoJugador juegoComprado) {
        if (this.jugadoresDuenios == null) {
            this.jugadoresDuenios = new LinkedList<>();
        }
        
        this.jugadoresDuenios.add(juegoComprado);
    }

//    public List<Videojuego> getVideojuegos() {
//        return videojuegos;
//    }
//
//    public void setVideojuegos(List<Videojuego> videojuegos) {
//        this.videojuegos = videojuegos;
//    }
//
//    public void addVideojuego(Videojuego videojuego) {
//        if (this.videojuegos == null) {
//            this.videojuegos = new LinkedList<>();
//        }
//        
//        this.videojuegos.add(videojuego);
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
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.dominio.Jugador[ id=" + id + " ]";
    }
}
