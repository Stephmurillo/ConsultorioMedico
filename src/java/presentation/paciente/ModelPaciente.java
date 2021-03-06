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
import logic.Paciente;

public class ModelPaciente {
    Paciente current;
    
    public ModelPaciente() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Paciente());        
    }
    
    public Paciente getCurrent() {
        return current;
    }

    public void setCurrent(Paciente current) {
        this.current = current;
    }
}
