/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author muril
 */
public class Especialidad {

    int id_especialidad;
    String nombre;
      
    public Especialidad(int id_especialidad, String nombre) {
        this.id_especialidad = id_especialidad;
        this.nombre = nombre;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }
    
    public String getNombre() {
        return nombre;
    }
    
}
