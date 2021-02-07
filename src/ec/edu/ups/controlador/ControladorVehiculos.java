/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Vehiculos;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author NANCY
 */
public class ControladorVehiculos extends ControladorA<Vehiculos>{

    @Override
    public List<Vehiculos> findAll() {
        Query consulta = getEm().createNamedQuery("Vehiculos.findAll");
        return consulta.getResultList();
    }
    
    public Vehiculos buscarPlaca(String placa){
        Query consulta = getEm().createNamedQuery("ConsultaPlaca");
        consulta.setParameter("placa", placa);
        return (Vehiculos) consulta.getSingleResult();
    }
    
}
