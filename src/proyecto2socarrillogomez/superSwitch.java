/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2socarrillogomez;

/**
 *
 * @author Alman
 */
public class superSwitch {
    int counter;
    int id;    
    public superSwitch() {        
        this.counter = 0;
    }
    public boolean sumarcontador(){
        this.counter += 1;
        // Retorna verdadero si el contador del switch llega a 15
        return counter == 15;        
    }
    public void resetearContador(){
    this.counter = 0;
    }
}
