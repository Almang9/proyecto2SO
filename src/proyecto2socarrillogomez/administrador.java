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
    public superSwitch getSwitch(){
        superSwitch consola = null;
    // Revisando que la cola de nivel 1 tenga una consola que retirar
        if(Simulacion.nivel1.getSize() != 0){
    consola = (superSwitch) Simulacion.nivel1.getFirst().getValue();    
    Simulacion.nivel1.desencolar();
    // Revisando que la cola de nivel 2 tenga una consola que retirar
    }else if (Simulacion.nivel2.getSize() != 0){
    consola = (superSwitch) Simulacion.nivel2.getFirst().getValue();    
    Simulacion.nivel2.desencolar();    
    // Revisando que la cola de nivel 3 tenga una consola que retirar
    }else if(Simulacion.nivel3.getSize()!= 0){
    consola = (superSwitch) Simulacion.nivel3.getFirst().getValue();    
    Simulacion.nivel3.desencolar();
    // Revisando que la cola de mejoras tenga una consola que retirar
    }else if(Simulacion.mejoras.getSize() != 0){
    consola = (superSwitch) Simulacion.mejoras.getFirst().getValue();    
    Simulacion.mejoras.desencolar();
    
    }
        return consola;
    }
    
    public void maybeCreateConsola(){
        double prob = Math.random();
        if (prob >= 70){
        System.out.println("Se creó una consola nueva");
        superSwitch nuevaConsola = new superSwitch();
        Simulacion.nivel3.encolar(nuevaConsola);        
        }else{
        System.out.println("No se creó nada");
        }
    }
    }

