package presentation.paciente;

import data.DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Paciente;
import logic.Persona;
import logic.Usuario;

@WebServlet(name = "ControllerPaciente", urlPatterns = {"/AccionPacienteRegistro", "/views/paciente/AccionPacienteRegistro"})
public class ControllerPaciente extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    
    private String crearPaciente(HttpServletRequest request) throws ParseException, SQLException {
        Usuario lastUser = DAO.readLastUsuario();
        Persona persona = new Persona(request.getParameter("nombre"), request.getParameter("apellido1"), request.getParameter("apellido2"), lastUser);
        Paciente paciente = new Paciente(request.getParameter("genero"), request.getParameter("fecha_nacimiento"), request.getParameter("telefono"), persona.getNombre(), persona.getApellido1(), persona.getApellido2(), lastUser);

        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                int dbStatusPersona = DAO.crearPersona(persona);
                int dbStatusPaciente = DAO.crearPaciente(paciente, dbStatusPersona);
                
                if (dbStatusPaciente > 0) return "./../login.jsp";
                else return "./../ViewError.jsp";
            } else {
                request.setAttribute("errores", errores);
                return "./../ViewError.jsp";
            }
        } catch (Exception e) {
            return "./../ViewError.jsp";
        }
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("nombre").isEmpty()) {
            errores.put("nombre", "Nombre requerido.");
        }
        if (request.getParameter("apellido1").isEmpty()) {
            errores.put("apellido1", "Apellido 1 requerida");
        }
        if (request.getParameter("apellido2").isEmpty()) {
            errores.put("apellido2", "Apellido 2 requerida");
        }
        if (request.getParameter("telefono").isEmpty()) {
            errores.put("telefono", "Telefono requerido");
        }
        return errores;
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ruta ="";
        try {
            ruta = this.crearPaciente(request);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect(ruta);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   /* @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    */
}
