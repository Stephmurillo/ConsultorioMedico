package presentation.login;

import java.io.IOException;
import java.io.PrintWriter;
import logic.Service;
import static java.lang.Integer.parseInt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Persona;
import logic.Usuario;

@WebServlet(name = "ControllerLogin", urlPatterns = {"/ControllerLogin"})
public class ControllerLogin extends HttpServlet {
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
    
    private String login(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.loginAction(request);
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
        return errores;
    }

    void updateModel(HttpServletRequest request) {
        ModelLogin model = (ModelLogin) request.getAttribute("ModelLogin");
        model.getCurrent().setCed_usuario(parseInt(request.getParameter("ced_usuario")));
        model.getCurrent().setContrasena(request.getParameter("contrasena"));
    }
    
    public String show(HttpServletRequest request){
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request){
      /*  ModelLogin model= (ModelLogin) request.getAttribute("model");
        Service serv = Service.instance();
        HttpSession session = request.getSession(true);
        Persona per = (Persona) session.getAttribute("usuario");
        Persona t1;
        try {
            t1 = Service.instance().personaAll();
            session.removeAttribute("usuario");
            session.setAttribute("persona", t1);
        } catch (Exception ex) {
            t1 = null;
        }
        try {
            model.setCurrent(t1);
            return "/presentation/cartelera/login.jsp";
        } catch (Exception ex) {
            return "";
        }*/
      return "";
    }    

    public String loginAction(HttpServletRequest request) {
        ModelLogin model = (ModelLogin) request.getAttribute("ModelLogin");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        try {
            String viewUrl = "";
            String rol = request.getParameter("user.id_rol");
            if("1".equals(rol)){
                Persona administrador = service.searchPersona(model.getCurrent().getCed_usuario(), model.getCurrent().getContrasenaU());
                session.setAttribute("usuario", administrador);
                viewUrl = "/ProyectoConsultorio/presentation/administrador/show";
            }
            if("2".equals(rol)){
                Persona medico = service.searchPersona(model.getCurrent().getCed_usuario(), model.getCurrent().getContrasenaU());
                session.setAttribute("usuario", medico);
                viewUrl = "/ProyectoConsultorio/presentation/medico/show";
            }
            if("3".equals(rol)){
                Persona paciente = service.searchPersona(model.getCurrent().getCed_usuario(), model.getCurrent().getContrasenaU());
                session.setAttribute("usuario", paciente);
                viewUrl = "/ProyectoConsultorio/presentation/paciente/show";
            }
            return viewUrl;
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("ced_usuario", "Usuario o contraseña incorrectos");
            errores.put("contrasena", "Usuario o contraseña incorrectos");
            return "/ViewError.jsp";
        }
    }
/*
    public String logout(HttpServletRequest request) {
        return this.logoutAction(request);
    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/index.jsp";
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        ModelLogin model = (ModelLogin) request.getAttribute("ModelLogin");
        model.getCurrent().setCed_usuario(0);
        model.getCurrent().setContrasena("");
        return "/ViewLogin.jsp";
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cedula = request.getParameter("ced_usuario");
 
        PrintWriter writer = response.getWriter();
        writer.println("<html>cedula: " + cedula + "</html>");
        writer.flush();        
//        processRequest(request, response);
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
