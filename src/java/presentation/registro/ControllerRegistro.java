package presentation.registro;

import data.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Usuario;

@WebServlet(name = "ControllerRegistro", urlPatterns = {"/AccionUsuarioRegistro", "/views/AccionUsuarioRegistro"})
public class ControllerRegistro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    
    private String crearUsuario(HttpServletRequest request) {        
        Usuario u = new Usuario(0, Integer.parseInt(request.getParameter("id_rol")),Integer.parseInt(request.getParameter("ced_usuario")),request.getParameter("contrasena"));
        String idRol = request.getParameter("id_rol");
        
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                int dbStatus = DAO.crearUsuario(u);
                if (dbStatus > 0 && idRol.equals("2")) return "./medico/registro.jsp";             
                if (dbStatus > 0 && idRol.equals("3")) return "./paciente/registro.jsp";
                else return "./login.jsp";
            } else {
                request.setAttribute("errores", errores);
                return "./ViewError.jsp";
            }
        } catch (Exception e) {
            return "./ViewError.jsp";
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
        String ruta = this.crearUsuario(request);
//        request.getRequestDispatcher(ruta).forward(request, response);
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
