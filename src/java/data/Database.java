/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author muril
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Persona;
import logic.Usuario;

public class Database {
    private static Database theInstance;
    public static Database instance(){
        if (theInstance == null){ 
            theInstance = new Database();
        }
        return theInstance;
    }
    public static final String PROPERTIES_FILE_NAME="./database.properties";        
    Connection cnx;
    
    public Database(){
        cnx = this.getConnection();            
    }
    public Connection getConnection(){

        try {
            Properties prop = new Properties();
            URL resourceUrl = getClass().getResource(PROPERTIES_FILE_NAME);
            File file = new File(resourceUrl.toURI());            
            prop.load(new BufferedInputStream(new FileInputStream(file)));
            String driver = prop.getProperty("database_driver");
            String server = prop.getProperty("database_server");
            String port = prop.getProperty("database_port");
            String user = prop.getProperty("database_user");
            String password = prop.getProperty("database_password");
            String database = prop.getProperty("database_name");
            
            String URL_conexion="jdbc:mysql://"+ server+":"+port+"/"+database+"?useSSL=false&allowPublicKeyRetrieval=true";            
            Class.forName(driver);
            return DriverManager.getConnection(URL_conexion, user, password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        } 
        return null;
    }
    
    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return cnx.prepareStatement(statement);
    }
    
    public Statement createStatement() {
        try {
            return cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public int executeUpdate(PreparedStatement statement) {
        try {
            statement.executeUpdate();
            return statement.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }
    public ResultSet executeQuery(PreparedStatement statement){
        try {
            return statement.executeQuery();
        } catch (SQLException ex) {
        }
        return null;
    }    
    
    public List<Persona> personas = new ArrayList<Persona>();

    public List<Persona> getListPersonas() {
        return personas;
    }
    
    public List<Usuario> usuarios = new ArrayList<Usuario>();

    public List<Usuario> getListUsuarios() {
        return usuarios;
    }
}
