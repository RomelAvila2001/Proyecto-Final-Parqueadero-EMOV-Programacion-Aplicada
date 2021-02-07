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
@NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f")
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    @OneToOne
    @JoinColumn(name="Clientesfk")
    private Clientes clientes;
    @OneToOne
    @JoinColumn(name="Sitiosfk")
    private Sitioss sitios;

    public Facturas() {
    }

    public Facturas(Long id, Calendar fechaYHoraDeIngreso, Calendar fechaYHoraDeSalida, String estado, double total, Clientes clientes, Sitioss sitios) {
        this.id = id;
        this.fechaYHoraDeIngreso = fechaYHoraDeIngreso;
        this.fechaYHoraDeSalida = fechaYHoraDeSalida;
        this.estado = estado;
        this.total = total;
        this.clientes = clientes;
        this.sitios = sitios;
    }

    public Facturas(Calendar fechaYHoraDeIngreso, Calendar fechaYHoraDeSalida, String estado, double total, Clientes clientes, Sitioss sitios) {
        this.fechaYHoraDeIngreso = fechaYHoraDeIngreso;
        this.fechaYHoraDeSalida = fechaYHoraDeSalida;
        this.estado = estado;
        this.total = total;
        this.clientes = clientes;
        this.sitios = sitios;
    }

    public Facturas(Calendar fechaYHoraDeIngreso, String estado, Clientes clientes, Sitioss sitios) {
        this.fechaYHoraDeIngreso = fechaYHoraDeIngreso;
        this.estado = estado;
        this.clientes = clientes;
        this.sitios = sitios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facturas{" + "id=" + id + ", fechaYHoraDeIngreso=" + fechaYHoraDeIngreso + ", fechaYHoraDeSalida=" + fechaYHoraDeSalida + ", estado=" + estado + ", total=" + total + ", clientes=" + clientes + ", sitios=" + sitios + '}';
    }

}
