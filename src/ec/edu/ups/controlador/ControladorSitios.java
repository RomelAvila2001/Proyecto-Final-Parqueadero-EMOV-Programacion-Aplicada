/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Sitioss;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author NANCY
 */
public class ControladorSitios extends ControladorA<Sitioss>{

    @Override
    public List<Sitioss> findAll() {
        Query consulta = getEm().createNamedQuery("Sitios.findAll");
        return consulta.getResultList();
    }
    
    public Sitioss buscarNumero(String numero){
            Query consulta = getEm().createNamedQuery("ConsultaCedula");
            consulta.setParameter("numero", numero);
            return (Sitioss) consulta.getSingleResult();
    }
    
}
