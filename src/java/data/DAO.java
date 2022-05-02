/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import static java.lang.Integer.parseInt;
import logic.Cita;
//import logic.Medico;
//import logic.Paciente;
import logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logic.Persona;

/**
 *
 * @author muril
 */
public class DAO {
     Database db;
    
    public DAO(){
        db = Database.instance();
    }
    
 /*   //---------------------------- MEDICOS ----------------------------
    public Medico readMedico(int id, String password) throws Exception {
        String sql = "select * from medicos where id=? and password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setString(2, password);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromMedicos(rs, "m"); } 
        else { throw new Exception("Medico no existe"); }
    }
    
    public Medico fromMedicos(ResultSet rs, String alias){
        try {
            Medico m = new Medico();
            m.setId_Usuario(parseInt(rs.getString(alias + ".id")));
            m.setContrasena(rs.getString(alias + ".password"));
            m.setNombre(rs.getString(alias + ".name"));
            return m;
        } catch (SQLException ex) { return null; }
    }
    
    public Medico searchMedico(int id) throws Exception {
        String sql = "select from * medicos where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromMedicos(rs, "m"); } 
        else { throw new Exception("Medico no existe"); }
    }
    
    //---------------------------- PACIENTES ----------------------------
    public Paciente readPaciente(int id, String password) throws Exception {
        String sql = "select * from pacientes where id=? and password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setString(2, password);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromPacientes(rs, "p"); } 
        else { throw new Exception("Paciente no existe"); }
    }
    
    public Paciente fromPacientes(ResultSet rs, String alias){
        try {
            Paciente p = new Paciente();
            p.setId_Usuario(parseInt(rs.getString(alias + ".id")));
            p.setContrasena(rs.getString(alias + ".password"));
            p.setNombre(rs.getString(alias + ".name"));
            return p;
        } catch (SQLException ex) { return null; }
    }
    
    public Paciente searchPaciente(String id) throws Exception {
        String sql = "select from * pacientes where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromPacientes(rs, "p"); } 
        else { throw new Exception("Paciente no existe"); }
    }
    */
    // ---------------------------------crear----------------
    public static int crearUsuario(Usuario u){  
    int status = 0;  
    String query = "insert into tb_usuarios(cedula,contrasena,id_rol) values(?,?,?)";
    try{  
        Database con = Database.instance();
        PreparedStatement ps= con.prepareStatement(query);  
        ps.setInt(1,u.getCed_usuario());  
        ps.setString(2,u.getContrasenaU());  
        ps.setInt(3,u.getId_rol());  
        status=ps.executeUpdate();  
    }catch(SQLException e){
        System.out.println(e);
    }  
    return status;  
}  
    
    public Usuario readUsuario(String id) throws Exception {
        String sql = "select * from tb_usuario where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromUsuarios(rs, "u"); } 
        else { throw new Exception("Usuario no existe"); }
    }
    
     public Usuario fromUsuarios(ResultSet rs, String alias){
        try {
            Usuario u = new Usuario();
            u.setId_usuario(parseInt(rs.getString(alias + ".id")));
            return u;
        } catch (SQLException ex) { return null; }
    }
    
    public int readLastIdUsuario() throws SQLException{
    int status = 0, id=0; 
    String query = "select max(id_usuario) as id_usuario from tb_usuarios";//agregar el id del usuario, para link
        Database con = Database.instance();
        PreparedStatement stm = db.prepareStatement(query);  
        ResultSet rs = db.executeQuery(stm);
        id = rs.getInt(1);
        return id;
    }
    
    
    public static int crearPersona(Persona p){  
    int status = 0;  
    String query = "insert into tb_personas(nombre,apellido1,apellido2,id_usuario) values(?,?,?,?)";//agregar el id del usuario, para link
    try{  
        Database con = Database.instance();
        PreparedStatement ps= con.prepareStatement(query);  
        ps.setString(1,p.getNombre());  
        ps.setString(2,p.getApellido1());  
        ps.setString(3,p.getApellido2()); 
        ps.setInt(3,p.getId_Usuario());  
        status=ps.executeUpdate();  
    }catch(SQLException e){
        System.out.println(e);
    }  
    return status;  
}  
    
    // ---------------------------------read----------------
    public Persona readPersona(int id, String password) throws Exception {
        String sql = "select * from tb_personas where id=? and password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setString(2, password);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromPersonas(rs, "a"); } 
        else { throw new Exception("Persona no existe"); }
    }
    
    public Persona fromPersonas(ResultSet rs, String alias){
        try {
            Persona a = new Persona();
            a.setId_Usuario(parseInt(rs.getString(alias + ".id")));
            a.setContrasena(rs.getString(alias + ".password"));
            a.setNombre(rs.getString(alias + ".name"));
            return a;
        } catch (SQLException ex) { return null; }
    }
    
    public Persona searchPersona(int id) throws Exception {
        String sql = "select from * tb_personas where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromPersonas(rs, "a"); } 
        else { throw new Exception("Persona no existe"); }
    }
    
//    //----------------------------- CITAS ----------------------------  
//    public Cita readCita(String id) throws Exception {
//        String sql = "select * from pacientes where id=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, id);
//        ResultSet rs = db.executeQuery(stm);
//        if (rs.next()) { return fromCitas(rs, "c"); } 
//        else { throw new Exception("Cita no existe"); }
//    }
//    
//    public Cita fromCitas(ResultSet rs, String alias){
//        try {
//            Cita c = new Cita();
//            c.setId_cita(parseInt(rs.getString(alias + ".id")));
//            return c;
//        } catch (SQLException ex) { return null; }
//    }
//    
//    public Cita searchCita(String id) throws Exception {
//        String sql = "select from * Cita where id=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, id);
//        ResultSet rs = db.executeQuery(stm);
//        if (rs.next()) { return fromCitas(rs, "c"); } 
//        else { throw new Exception("Cita no existe"); }
//    }
}
