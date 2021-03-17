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
    private nodo first;
    private nodo last;
    private int size;

    private void setFirst(nodo first) {
        this.first = first;
    }

    private void setLast(nodo last) {
        this.last = last;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private nodo getFirst() {
        return first;
    }

    private nodo getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
    return size == 0;
    }
    public void encolar(){
        nodo aux = new nodo(Simulacion.idCounter+1);
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
    public void encolar(nodo node){
    nodo aux = node;
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
    public nodo desencolar(){        
        nodo aux = first;
        first = first.getNext();
        return aux;
    
    
    
    }
    public void print(){
        nodo aux = first;
        while (aux != null){
            System.out.println(" | ID: " + aux.getId() +" Prioridad: " + aux.prioridad + " | ");
            aux = aux.getNext();
        }
    }
    public nodo actualizarContador(){
    nodo resp = null;
    nodo aux = getFirst();
    boolean contador;
    while (aux != null){
            contador = aux.sumarcontador();
            aux = aux.getNext();
            if(contador){
            resp = desencolar();
            return resp;
            }
        }
        return resp;
    }
}
