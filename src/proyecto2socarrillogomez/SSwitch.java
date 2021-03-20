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
public class SSwitch {
    private SSwitch next;
    int counter;
    int id;
    int prioridad;
    
    //Constructor
    public SSwitch(int id, int prioridad){
    this.id =id;
    this.prioridad = prioridad;
    this.next = null;
    this.counter = 0;
    }  
    
    public int getId() {
        return id;
    }

    public SSwitch getNext() {
        return next;
    }

    public void setNext(SSwitch next) {
        this.next = next;
    }
    
    public void sumarContador(){
        this.counter++;
    }
    
    public void resetearContador(){
        this.counter = 0;
    }
}

