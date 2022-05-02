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
public class Cita {
    int id_cita;
    int id_paciente;
    int id_medico;
    int id_especialidad;
    Date fecha;
    String comentarios = "";
    char estado;

    public Cita(int id_cita, int id_paciente, int id_medico, int id_especialidad, Date fecha) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.id_especialidad = id_especialidad;
        this.fecha = fecha;
        this.estado = 'a'; // declara el estado de la cita como activa
    }

    public Cita() {
        this.id_cita = 0;
        this.id_paciente = 0;
        this.id_medico = 0;
        this.id_especialidad = 0;
        this.fecha = null;
        this.estado = 'a'; // declara el estado de la cita como activa
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getId_cita() {
        return id_cita;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    
}
