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
public class nodo {
    private nodo next;
    int counter;
    int id;
    int prioridad;
    //Constructor
    public nodo(int id){
    this.id =id;
    prioridad = 3;
    this.next = null;
    this.counter = 0;
    }     
    public int getId() {
        return id;
    }

    public nodo getNext() {
        return next;
    }

    public void setId(int value) {
        this.id = value;
    }

    public void setNext(nodo next) {
        this.next = next;
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

