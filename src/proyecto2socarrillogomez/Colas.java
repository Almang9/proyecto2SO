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

    public void setFirst(nodo first) {
        this.first = first;
    }

    public void setLast(nodo last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public nodo getFirst() {
        return first;
    }

    public nodo getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
    return size == 0;
    }
    public void encolar(Object value){
        nodo aux = new nodo(value);
        if (isEmpty()) {
            first = aux;
            last = aux;
            
        }else{
        last.setNext(aux);
        setLast(aux);
        }
    }
    public void desencolar(){        
        first = first.getNext();
        
    
    
    
    }
}
