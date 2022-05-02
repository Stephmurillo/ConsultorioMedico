/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.Date;

/**
 *
 * @author muril
 */
public class Horario {
    int id_horario;
    Date fecha;
    Localidad localidad;
    boolean disponibilidad;

    public Horario(int id_horario, Date fecha, Localidad localidad, boolean disponibilidad) {
        this.id_horario = id_horario;
        this.fecha = fecha;
        this.localidad = localidad;
        this.disponibilidad = disponibilidad;
    }

    public int getId_horario() {
        return id_horario;
    }

    public Date getFecha() {
        return fecha;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    
    public void setDisponibilidad(){
        disponibilidad ^= true;
    }
}
