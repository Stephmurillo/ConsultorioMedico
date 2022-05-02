/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author muril
 */
public class Rol { 
    
    int id_rol;
    String nombre;
    
    public Rol(){
        this.id_rol = 0;
        this.nombre = "";
    }
    
    public Rol(int id_rol, String nombre){
        this.id_rol = id_rol;
        this.nombre = nombre;
    }
    
    public int getId_rol() {
        return id_rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
