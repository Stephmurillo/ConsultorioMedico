package presentation.paciente;

import data.DAO;
import java.io.IOException;
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
import logic.Usuario;

@WebServlet(name = "ControllerRegistro", urlPatterns = {"/AccionRegistro", "/views/AccionRegistro"})
public class ControllerPaciente extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
//        request.setAttribute("ModelLogin", new ModelLogin());
//        String viewUrl = "";
//        switch (request.getServletPath()) {
//            case "/presentation/login/show":
//                viewUrl = this.show(request);
//                break;
//            case "/login":
//                viewUrl = this.login(request);
//                break;
//            case "/presentation/login/logout":
//              //  viewUrl = this.logout(request);
//                break;
//        }
//        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    private String crearPaciente(HttpServletRequest request) throws ParseException {
        Usuario u = new Usuario();
        Date date =new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fecha_nacimiento"));
        String id = DAO.
        Paciente p = new Paciente(request.getParameter("genero"), date, request.getParameter("telefono"),
                                  request.getParameter("nombre"),request.getParameter("apellido1"),request.getParameter("apellido2"),u);
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                int dbStatus1 = DAO.crearPersona(p);
                int dbStatus2 = DAO.crearPaciente(u);
                
                return "/views/login.jsp";
            } else {
                request.setAttribute("errores", errores);
                return "/index.jsp";
            }
        } catch (Exception e) {
            return "/ViewError.jsp";
        }
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("ced_usuario").isEmpty()) {
            errores.put("ced_usuario", "Numeo de identificación requerido");
        }
        if (request.getParameter("contrasena").isEmpty()) {
            errores.put("contrasena", "Contraseña requerida");
        }
        if (request.getParameter("id_rol").isEmpty()) {
            errores.put("id_rol", "Rol del usuario requerido");
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
        }
        
        request.getRequestDispatcher(ruta).forward(request, response);
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
