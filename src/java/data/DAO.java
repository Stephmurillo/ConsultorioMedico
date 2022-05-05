/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import static java.lang.Integer.parseInt;
import logic.Usuario;
import java.sql.*;
import java.util.List;
import logic.Medico;
import logic.Mensualidad;
import logic.Persona;
import logic.Paciente;

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

    
    public static int crearPersona(Persona p){  
        int lastId = 0;
        String query = String.format("insert into tb_personas(nombre,apellido1,apellido2,id_usuario) values('%s','%s','%s',%d)",
                p.getNombre(), p.getApellido1(), p.getApellido2(), p.getId_Usuario());
        try{  
            Database con = Database.instance();
            Statement ps = con.createStatement();

            ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                lastId =rs.getInt(1);
            }

        } catch(SQLException e){
            System.out.println(e);
        } 
        
        return lastId;
    }
    
    public static int crearPaciente(Paciente p, int idLastPerson){  
        int lastId = 0;
        String query = String.format("insert into tb_pacientes(genero,telefono,fecha_nacimiento,id_persona) values('%s','%s','%s',%d)",
                p.getGenero(), p.getTelefono(), p.getFechaNacimiento(), idLastPerson);
        try{  
            Database con = Database.instance();
            Statement ps = con.createStatement();

            ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                lastId =rs.getInt(1);
            }

        } catch(SQLException e){
            System.out.println(e);
        } 
        
        return lastId;
    }
    
    public static int crearMedico(Medico m, int idLastPerson){  
        int lastId = 0;
        String query = String.format("insert into tb_medicos(genero,costo_consulta,frecuencia_citas,id_persona) values('%s','%s','%s',%d)",
                m.getGenero(), m.getCosto_consulta(), m.getFrecuencia_citas(), idLastPerson);
        try{  
            Database con = Database.instance();
            Statement ps = con.createStatement();

            ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                lastId =rs.getInt(1);
            }

        } catch(SQLException e){
            System.out.println(e);
        } 
        
        return lastId;
    }
    
    public static int crearMensualidad(Mensualidad m){  
        String query = "insert into tb_mensualidad(mes,costo,estado) values(?,?,?)";
        int status = 0;  
        try{
            Database con = Database.instance();
            PreparedStatement ps= con.prepareStatement(query); 
            ps.setInt(1,m.getMes());  
            ps.setDouble(2,m.getCosto());  
            ps.setString(3,String.valueOf(m.getEstado())); 
            status= ps.executeUpdate();  //eroror!!!!
        }catch(SQLException e){
            System.out.println(e);
        }  
        return status;  
    }
    
    // ---------------------------------read----------------
    
     public List<Medico> readMedicos() throws Exception {
        String sql = "select * from tb_medicos";
        PreparedStatement stm = db.prepareStatement(sql);
        ResultSet rs = db.executeQuery(stm);
        List<Medico> medicos = null;
        while (rs.next()) { 
            Medico med = new Medico();//agregar parametros desde el resulset
            medicos.add(med);
        } 
        return medicos;
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
    
    public static Usuario readLastUsuario() throws SQLException{
        int status = 0, id=0,idRol=0, cedula=0;
        String contrasena = "";
        
        String query = "select * from tb_usuarios order by id_usuario desc limit 1;";
        Database con = Database.instance();
        PreparedStatement stm = con.prepareStatement(query);  
        ResultSet rs = con.executeQuery(stm);
        
        if (rs.next()) {
            id = rs.getInt("id_usuario");
            idRol = rs.getInt("id_rol");
            cedula = rs.getInt("cedula");
            contrasena = rs.getString("contrasena");
        }
        
        return new Usuario(id, idRol, cedula, contrasena);
    }
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
    
    public Mensualidad fromMensualidades(ResultSet rs, String alias){
        try {
            Mensualidad a = new Mensualidad();
            a.setCosto(parseInt(rs.getString(alias + ".costo")));
            a.setMes(parseInt(rs.getString(alias + ".mes")));
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
