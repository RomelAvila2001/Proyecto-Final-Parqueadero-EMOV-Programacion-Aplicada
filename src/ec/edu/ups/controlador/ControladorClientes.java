/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Clientes;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author NANCY
 */
public class ControladorClientes extends ControladorA<Clientes>{

    @Override
    public List<Clientes> findAll() {
        Query consulta = getEm().createNamedQuery("Clientes.findAll");
        return consulta.getResultList();
    }
    
    public Clientes buscarCedula(String cedula){
        Query consulta = getEm().createNamedQuery("ConsultaCedula");
        consulta.setParameter("cedula", cedula);
        return (Clientes) consulta.getSingleResult();
    }
    
}
