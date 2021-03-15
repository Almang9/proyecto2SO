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
    private Object value;
    private nodo next;
    public nodo(Object value){
    this.value = value;
    this.next = null;
    }

    public Object getValue() {
        return value;
    }

    public nodo getNext() {
        return next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(nodo next) {
        this.next = next;
    }

}

