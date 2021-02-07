/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Usuarios;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Query;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author NANCY
 */
public class ControladorUsuarios extends ControladorA<Usuarios>{

    @Override
    public List<Usuarios> findAll() {
        Query consulta = getEm().createNamedQuery("Usuarios.findAll");
        return consulta.getResultList();
    }
    
    public Usuarios iniciarSesion(String correo, String contrase,String keyUnlock) {
        
       var ListaUsuario= (List<Usuarios>) findAll();
        
        Usuarios usuario= ListaUsuario.stream().filter(usu-> usu.getCorreo().equals(correo)&&deecnode(keyUnlock, usu.getContraseña()).equals(contrase)).findFirst().get();
        if(usuario!=null){
            Usuarios.instance=usuario;
            return Usuarios.getInstance();
        }
        return null;
    } 
    
    public String ecriptarContraseña(String key, String contraseña){
        String encriptacion= " ";
        try{
            MessageDigest msmd= MessageDigest.getInstance("MD5");
            byte[] llaveContrase=msmd.digest(key.getBytes("utf-8"));
            byte[] bytesKey= Arrays.copyOf(llaveContrase, 24);
            SecretKey secretKey= new SecretKeySpec(bytesKey, "DESede");
            
            Cipher cifrado= Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, secretKey);
            
            byte[] bytesContrase= contraseña.getBytes("utf-8");
            byte[] buffer= cifrado.doFinal(bytesContrase);
            byte[] base64Byte= Base64.encodeBase64(buffer);
            
            encriptacion= new String(base64Byte);
            return encriptacion;     
        } catch (Exception ex) {
            System.out.println("algo esta mal");
        }
        return null;
    }  
    
    public String deecnode(String secretKey, String contraseñaencode) {
        String desencriptacion = "";
        try {
            byte[] message = Base64.decodeBase64(contraseñaencode.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            desencriptacion = new String(plainText, "UTF-8");
            return desencriptacion;

        } catch (Exception ex) {
            System.out.println("algo esta mal");
        }
        return null;
    }
}
