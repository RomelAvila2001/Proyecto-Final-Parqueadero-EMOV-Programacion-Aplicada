/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author NANCY
 */
@Entity
@NamedQuery(name = "Sitios.findAll", query = "SELECT s FROM Sitioss s")
public class Sitioss implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @Column
    private String estado;
    
    @OneToOne
    @JoinColumn(name="Vehiculosfk")
    private Vehiculos vehiculos;

    public Sitioss() {
    }

    public Sitioss(String id, String estado, Vehiculos vehiculos) {
        this.id = id;
        this.estado = estado;
        this.vehiculos = vehiculos;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
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
        if (!(object instanceof Sitioss)) {
            return false;
        }
        Sitioss other = (Sitioss) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.modelo.Sitioss[ id=" + id + " ]";
    }
    
}
