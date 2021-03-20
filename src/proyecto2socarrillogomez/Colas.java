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
public class Colas {
    private SSwitch first;
    private SSwitch last;
    private int size;
    
    public Colas() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    public void setFirst(SSwitch first) {
        this.first = first;
    }

    public void setLast(SSwitch last) {
        this.last = last;
    }

    public SSwitch getFirst() {
        return first;
    }

    public SSwitch getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void encolar(SSwitch node){
        SSwitch aux = node;
        if (isEmpty()) {
            first = aux;
            last = aux;   
            size++;
        }else{
            last.setNext(aux);
            setLast(aux);
            size++;
        }
    }
    
    public SSwitch desencolar(){        
        SSwitch aux = first;
        if (!isEmpty()) {
            first = first.getNext();
            aux.setNext(null);
            size--;
            if (size == 0) {
                setLast(null);
            }
            return aux;
        }
        return null;
    }
    
    public void print(){
        SSwitch aux = first;
        while (aux != null){
            System.out.println(" | ID: " + aux.getId() +" Prioridad: " + aux.prioridad + " | ");
            aux = aux.getNext();
        }
    }
    
    public void actualizarContador() {
        if (!isEmpty()) {
            SSwitch aux = getFirst();
            while (aux != null) {
                aux.sumarContador();
                if (aux.counter == 15 && aux.prioridad > 1) {
                    aux.prioridad--;
                    aux.resetearContador();
                }
                aux = aux.getNext();
            }
        } 
    }
    
//    public SSwitch actualizarContador(){
//        SSwitch resp = null;
//        SSwitch aux = getFirst();
//        while (aux != null){
//            aux.sumarcontador();
//            aux = aux.getNext();
//            if(aux.counter == 15){
//                resp = desencolar();
//                return resp;
//            }
//        }
//        return resp;
//    }
}
