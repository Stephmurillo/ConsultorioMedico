/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author muril
 */
public class Persona {

    int id_persona;
    String  nombre;
    String apellido1;
    String apellido2;
    Usuario usuario; 
    
    public Persona(String nombre, String apellido1, String apellido2, Usuario usuario) {
        this.id_persona = 0;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.usuario = usuario;
    }

    public Persona() {
        this.id_persona = 0;
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.usuario = null;
    }
     
    public int getId_persona() {
        return id_persona;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getCed_Usuario() {
        return usuario.getCed_usuario();
    }
    public String getContrasenaU() {
        return usuario.getContrasenaU();
    }
    
    public void setContrasena(String pass){
        usuario.contrasena = pass;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    } 
    public void setId_Usuario(int idusuario) {
        usuario.ced_usuario = idusuario;
    }
    public int getId_Usuario() {
        return usuario.getId_usuario();
    }
}
