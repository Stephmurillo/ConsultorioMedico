/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.List;

/**
 *
 * @author muril
 */
public class Medico extends Persona{
    int id_medico;
    double costo_consulta;
    boolean estado_ingreso;
    int frecuencia_citas;
    String ruta_img;
    List<Especialidad> especialidades;
    List<Mensualidad> mensualidades;
    List<Horario> horarios;

    public Medico(double costo_consulta, int frecuencia_citas, String ruta_img,
            int id_persona, String nombre, String apellido1, String apellido2, Usuario usuario, 
            List<Especialidad> especialidades, List<Mensualidad> mensualidades, List<Horario> horarios) {
        super(nombre, apellido1, apellido2, usuario);
        this.id_medico = 0;
        this.costo_consulta = costo_consulta;
        this.frecuencia_citas = frecuencia_citas;
        this.ruta_img = ruta_img;
        this.estado_ingreso = false;
        this.especialidades = especialidades;
        this.mensualidades = mensualidades;
        this.horarios = horarios;
    }
    
    public Medico() {
        super();
        this.id_medico = 0;
        this.costo_consulta = 0;
        this.frecuencia_citas = 0;
        this.ruta_img = "";
        this.estado_ingreso = false;
        this.especialidades = null;
        this.mensualidades = null;
        this.horarios = null;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public List<Mensualidad> getMensualidades() {
        return mensualidades;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public int getId_medico() {
        return id_medico;
    }
    
    public double getCosto_consulta() {
        return costo_consulta;
    }

    public void setCosto_consulta(double costo_consulta) {
        this.costo_consulta = costo_consulta;
    }

    public boolean isEstado_ingreso() {
        return estado_ingreso;
    }

    public void setEstado_ingreso(boolean estado_ingreso) {
        this.estado_ingreso = estado_ingreso;
    }

    public int getFrecuencia_citas() {
        return frecuencia_citas;
    }

    public void setFrecuencia_citas(int frecuencia_citas) {
        this.frecuencia_citas = frecuencia_citas;
    }

    public String getRuta_img() {
        return ruta_img;
    }

    public void setRuta_img(String ruta_img) {
        this.ruta_img = ruta_img;
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

    public Usuario getUsuario() {
        return usuario;
    }
    
    public int getCed_Usuario() {
        return usuario.getCed_usuario();
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    
    public void setId_Usuario(int idusuario) {
        usuario.ced_usuario = idusuario;
    }
   
    public String getCont_Usuario() {
        return usuario.getContrasenaU();
    }

    
}
