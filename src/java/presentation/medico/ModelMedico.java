/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.medico;

/**
 *
 * @author muril
 */

import presentation.paciente.*;
import presentation.registro.*;
import presentation.login.*;
import logic.Medico;

public class ModelMedico {
    Medico current;
    
    public ModelMedico() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Medico());        
    }
    
    public Medico getCurrent() {
        return current;
    }

    public void setCurrent(Medico current) {
        this.current = current;
    }
}
