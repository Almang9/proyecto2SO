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
public class administrador {
    public nodo getSwitch(){
        nodo consola = null;
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
        Simulacion.nivel3.encolar(new nodo(Simulacion.idCounter));
        Simulacion.idCounter++;
        }else{
        System.out.println("No se creó nada");
        }
    }
    public void actualizarColas(){
    Simulacion.nivel1.actualizarContador();
    
    }
    }

