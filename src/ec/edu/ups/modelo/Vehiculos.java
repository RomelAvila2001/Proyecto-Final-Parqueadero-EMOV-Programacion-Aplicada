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
@NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")
@NamedQuery(name = "ConsultaPlaca", query = "SELECT v FROM Vehiculos v where v.placa = :placa")
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String color;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private String placa;
    
    @OneToOne
    @JoinColumn(name="Clientesfk")
    private Clientes clientes;

    public Vehiculos() {
    }
    
    public Vehiculos(Long id, String color, String marca, String modelo, String placa, Clientes clientes) {
        this.id = id;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.clientes = clientes;
    }
    public Vehiculos(String color, String marca, String modelo, String placa, Clientes clientes) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.clientes = clientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
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
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "id=" + id + ", color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + ", clientes=" + clientes + '}';
    }
    
}
