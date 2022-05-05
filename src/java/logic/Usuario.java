/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author muril
 */
public class Usuario {
    int id_usuario;
    int id_rol;
    int ced_usuario;
    String contrasena;
    
    public Usuario(int id_usuario, int id_rol, int ced_usuario, String contrasena) {
        this.id_usuario = id_usuario;
        this.id_rol = id_rol;
        this.ced_usuario = ced_usuario;
        this.contrasena = contrasena;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
    
     public Usuario() {
        this.id_usuario = 0;
        this.id_rol = 0;
        this.ced_usuario = 0;
        this.contrasena = "";
    }
 
    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public int getCed_usuario() {
        return ced_usuario;
    }

    public void setCed_usuario(int ced_usuario) {
        this.ced_usuario = ced_usuario;
    }

    public String getContrasenaU() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
