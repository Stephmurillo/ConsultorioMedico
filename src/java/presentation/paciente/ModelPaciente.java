/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.paciente;

/**
 *
 * @author muril
 */

import presentation.registro.*;
import presentation.login.*;
import logic.Usuario;

public class ModelPaciente {
    Usuario current;
    
    public ModelPaciente() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Usuario());        
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }
}
