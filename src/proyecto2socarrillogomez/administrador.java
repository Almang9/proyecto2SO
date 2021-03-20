/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2socarrillogomez;
import java.lang.Math;
/**
 *
 * @author Alman
 */
public class Administrador {
    Colas nivel1;
    Colas nivel2;
    Colas nivel3;
    Colas mejoras;
    int nextId;
    
    public Administrador() {
        nivel1 = new Colas();
        nivel2 = new Colas();
        nivel3 = new Colas();
        mejoras = new Colas();
        nextId = 0;
    }
    
    public SSwitch getSwitch() {
        SSwitch consola = null;
        SSwitch cambio = null;
        if (!nivel1.isEmpty()) {
            consola = nivel1.desencolar();
            consola.resetearContador();
        }
        else if(!nivel2.isEmpty()) {
            consola = nivel2.desencolar();
            consola.resetearContador();
        }
        else if(!nivel3.isEmpty()) {
            consola = nivel3.desencolar();
            consola.resetearContador();
        }
        nivel1.actualizarContador();
        nivel2.actualizarContador();
        nivel3.actualizarContador();
        mejoras.actualizarContador();
        if (!nivel2.isEmpty()) {
            if (nivel2.getFirst().prioridad != 2) {
                cambio = nivel2.desencolar();
                nivel1.encolar(cambio);
            }
        }
        if (!nivel3.isEmpty()) {
            if (nivel3.getFirst().prioridad != 3) {
                cambio = nivel3.desencolar();
                nivel2.encolar(cambio);
            }
        }
        return consola;
    }
    
    public void encolarListos(SSwitch nodo) {
        if (nodo != null) {
            switch(nodo.prioridad) {
                case 1:
                    nivel1.encolar(nodo);
                    break;
                case 2:
                    nivel2.encolar(nodo);
                    break;
                case 3:
                    nivel3.encolar(nodo);
                    break;
            }
        }
    }
    
    public void encolarMejoras(SSwitch nodo) {
        if (nodo != null) {
            mejoras.encolar(nodo);
        }
    }
    
    public void crearConsola() {
        int nivel = 1 + (int)(Math.random()*((3-1)+1)); //Genera un número entre 1 y 3
        SSwitch consola = new SSwitch(nextId, nivel);
        encolarListos(consola);
        nextId++;
    }
    
    /*public SSwitch getSwitch(){
        SSwitch consola = null;
    // Revisando que la cola de nivel 1 tenga una consola que retirar
        if(Simulacion.nivel1.getSize() != 0){
            consola =  Simulacion.nivel1.desencolar();
            Simulacion.nivel1.desencolar();
    // Revisando que la cola de nivel 2 tenga una consola que retirar
        }else if (Simulacion.nivel2.getSize() != 0){
            consola =  Simulacion.nivel2.desencolar();
            Simulacion.nivel2.desencolar();
    // Revisando que la cola de nivel 3 tenga una consola que retirar
        }else if(Simulacion.nivel3.getSize()!= 0){
            consola =  Simulacion.nivel3.desencolar();
            Simulacion.nivel3.desencolar();
    // Revisando que la cola de mejoras tenga una consola que retirar
        }else if(Simulacion.mejoras.getSize() != 0){
            consola =  Simulacion.mejoras.desencolar();    
            Simulacion.mejoras.desencolar();
    
    }
        return consola;
    }
    
    public void maybeCreateConsola(){
        double prob = Math.random();
        if (prob > 0.3){
        System.out.println("Se creó una consola nueva");        
        Simulacion.nivel3.encolar(new SSwitch(Simulacion.idCounter));
        Simulacion.idCounter++;
        }else{
        System.out.println("No se creó nada");
        }
    }
    public void actualizarColas(){
    Simulacion.nivel1.actualizarContador();
    
    }*/
}

