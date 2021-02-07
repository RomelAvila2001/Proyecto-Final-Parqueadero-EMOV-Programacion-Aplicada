/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author NANCY
 */
@Entity
@NamedQuery(name = "Contratos.findAll", query = "SELECT con FROM Contratos con")
public class Contratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="Clientesfk")
    private Clientes clientes;
    @OneToOne
    @JoinColumn(name="Sitiosfk")
    private Sitioss sitios;
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar fechaYHoraDeIngreso;
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar fechaYHoraDeSalida;
    @Column
    private String estado;
    @Column
    private double total;

    public Contratos() {
    }

    public Contratos(Long id, Clientes clientes, Sitioss sitios, Calendar fechaYHoraDeIngreso, Calendar fechaYHoraDeSalida, String estado, double total) {
        this.id = id;
        this.clientes = clientes;
        this.sitios = sitios;
        this.fechaYHoraDeIngreso = fechaYHoraDeIngreso;
        this.fechaYHoraDeSalida = fechaYHoraDeSalida;
        this.estado = estado;
        this.total = total;
    }
      
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Sitioss getSitios() {
        return sitios;
    }

    public void setSitios(Sitioss sitios) {
        this.sitios = sitios;
    }

    public Calendar getFechaYHoraDeIngreso() {
        return fechaYHoraDeIngreso;
    }

    public void setFechaYHoraDeIngreso(Calendar fechaYHoraDeIngreso) {
        this.fechaYHoraDeIngreso = fechaYHoraDeIngreso;
    }

    public Calendar getFechaYHoraDeSalida() {
        return fechaYHoraDeSalida;
    }

    public void setFechaYHoraDeSalida(Calendar fechaYHoraDeSalida) {
        this.fechaYHoraDeSalida = fechaYHoraDeSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        if (!(object instanceof Contratos)) {
            return false;
        }
        Contratos other = (Contratos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contratos{" + "id=" + id + ", clientes=" + clientes + ", sitios=" + sitios + ", fechaYHoraDeIngreso=" + fechaYHoraDeIngreso + ", fechaYHoraDeSalida=" + fechaYHoraDeSalida + ", estado=" + estado + ", total=" + total + '}';
    }

}
