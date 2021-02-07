/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Facturas;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author NANCY
 */
public class ControladorFacturas extends ControladorA<Facturas>{

    @Override
    public List<Facturas> findAll() {
        Query consulta = getEm().createNamedQuery("Facturas.findAll");
        return consulta.getResultList();
    }
    
}
