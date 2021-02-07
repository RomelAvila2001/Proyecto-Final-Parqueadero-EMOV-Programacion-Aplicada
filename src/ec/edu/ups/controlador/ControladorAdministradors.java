/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Administrador;

/**
 *
 * @author NANCY
 */
public class ControladorAdministradors {
    Administrador administrador = new Administrador(1, "0567123489", "Juan", "Mendez","a", "123");
    
    public Administrador iniciarSesion(String correo, String contrase){
        if (administrador.getCorreo().equals(correo) && administrador.getContraseña().equals(contrase)) {
            return administrador;
        }
        return null;
    }
}
