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
public class Paciente extends Persona{
    int id_paciente;
    String genero;
    Date fecha_nacimiento;
    String telefono;

    public Paciente(String genero, Date fecha_nacimiento, String telefono, String nombre, String apellido1, String apellido2, Usuario usuario) {
        super(nombre, apellido1, apellido2, usuario);
        this.id_paciente = 0;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
    }

    public Paciente(){
        super();
        this.id_paciente = 0;
        this.genero = "";
        this.fecha_nacimiento = null;
        this.telefono = "";
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public String getGenero() {
        return genero;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }
     
    public int getCed_Usuario() {
        return usuario.getCed_usuario();
    }
    
    public void setId_Usuario(int idusuario) {
        usuario.ced_usuario = idusuario;
    }
      
    public String getCont_Usuario() {
        return usuario.getContrasenaU();
    } 

}
