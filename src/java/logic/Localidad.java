/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author muril
 */
public class Localidad {
    int id_localidad;
    String ciudad;
    
    public Localidad(int id_localidad, String ciudad) {
        this.id_localidad = id_localidad;
        this.ciudad = ciudad;
    }

    public void setId_localidad(int id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getCiudad() {
        return ciudad;
    }
}
