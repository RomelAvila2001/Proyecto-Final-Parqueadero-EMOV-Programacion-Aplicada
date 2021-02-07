/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author NANCY
 */
@Entity
@NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String correo;
    @Column
    private String contraseña;
    @Column
    private String cedula;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    
    public static Usuarios instance;
    
    private Usuarios() {
    }

    private Usuarios(Long id) {
        this.id = id;
    }

    private Usuarios(Long id, String correo, String contraseña, String cedula, String nombre, String apellido, Calendar fechaNacimiento) {
        this.id = id;
        this.correo = correo;
        this.contraseña = contraseña;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public static Usuarios getInstance(){
        if(Usuarios.instance==null){
            Constructor<Usuarios> constructor;
            try{
                constructor=Usuarios.class.getDeclaredConstructor();
                constructor.setAccessible(true);
                
                Usuarios usuario=constructor.newInstance();
                
                Usuarios.instance=usuario;
            }catch(Exception e){
                e.printStackTrace();
            }
            return Usuarios.instance;
        }
        return Usuarios.instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.correo);
        hash = 67 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuarios other = (Usuarios) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.modelo.Usuarios[ id=" + id + " ]";
    }
    
}
