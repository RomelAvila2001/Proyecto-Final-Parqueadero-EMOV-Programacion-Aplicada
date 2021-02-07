/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Contratos;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author NANCY
 */
public class ControladorContratos extends ControladorA<Contratos>{

    @Override
    public List<Contratos> findAll() {
        Query consulta = getEm().createNamedQuery("Contratos.findAll");
        return consulta.getResultList();
    }
    
}
