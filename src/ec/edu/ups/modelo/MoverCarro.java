/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author NANCY
 */
public class MoverCarro implements Runnable{
    int espacios;
    JLabel label;

    public MoverCarro() {
    }

    
    public MoverCarro(int espacios, JLabel label) {
        this.espacios = espacios;
        this.label = label;
    }

    
    @Override
    public void run() {
        int ubicacionX = label.getLocation().x;
        int ubicacionY = label.getLocation().y;
        boolean b = false;
        while (b == false) {
            for (int i = 0; i <espacios; i++) {
                
                try {
                    label.setLocation(label.getLocation().x + 10, label.getLocation().y);
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MoverCarro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            b=true;
            try {
                Thread.sleep(50000);
                label.setLocation(ubicacionX, ubicacionY);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoverCarro.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }   
    }
    
    
}
