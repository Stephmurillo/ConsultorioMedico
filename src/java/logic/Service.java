/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import data.DAO;
import data.Database;
import java.util.List;

/**
 *
 * @author muril
 */
public class Service {
    
    private static Service uniqueInstance;
    
    public static Service instance(){
        if(uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    private Database db = new Database();
    private DAO dao = new DAO();
    
    //--------------------------- MEDICO ---------------------------
    public Medico searchMedico(int ID, String password) throws Exception{
        Medico med = (Medico) dao.readPersona(ID, password);
        if(med != null && med.getCont_Usuario().equals(password)){
            return med;
        }else{
            throw new Exception("Error");
        }
    }    
    
    //--------------------------- PACIENTE ---------------------------ready
    public Paciente searchPaciente(int ID, String password) throws Exception{
        Paciente pac = (Paciente) dao.readPersona(ID, password);
        if(pac != null && pac.getCont_Usuario().equals(password)){
            return pac;
        }else{
            throw new Exception("Error");
        }
    } 
    
    //--------------------------- ADMINISTRADOR ---------------------------
    public Persona searchPersona(int ID, String password) throws Exception{
        Persona ad = dao.readPersona(ID, password);
        if(ad != null && ad.getContrasenaU().equals(password)){
            return ad;
        }else{
            throw new Exception("Error");
        }
    } 
    
    public List<Persona> personaAll(){
        return Database.instance().getListPersonas();       
    }
    
    public List<Usuario> usuarioAll(){
        return Database.instance().getListUsuarios();       
    }
}
